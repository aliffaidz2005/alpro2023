package project.app.service;

import jakarta.servlet.http.Cookie;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import project.app.entity.Todo;
import project.app.exception.LoginExceptionUnautorized;
import project.app.entity.User;
import project.app.exception.UnautorizedUserException;
import project.app.model.*;
import project.app.repository.TodoRespository;
import project.app.repository.UserRespository;
import project.app.util.BCrypt;
import project.app.util.ValidationService;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class UserService {

    private final UserRespository userRespository;
    private final ValidationService validationService;
    private final TodoRespository todoRespository;

    public UserService(UserRespository userRespository,ValidationService validationService, TodoRespository todoRespository){
        this.userRespository = userRespository;
        this.validationService = validationService;
        this.todoRespository = todoRespository;
    }

    @Transactional
    public void register(UserRegisterRequest request){
        log.info("Register " + Thread.currentThread().getName() + " user " + request.getUsername());
        validationService.validation(request);

        boolean present = userRespository.findFirstUserByUsername(request.getUsername()).isPresent();
        if(present){
            throw new LoginExceptionUnautorized("username sudah digunakan");
        }

        userRespository.save(
                User.builder()
                        .username(request.getUsername())
                        .password(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt()))
                        .build()
        );
    }

    @Transactional
    public UserLoginResponse login(UserLoginRequest request){
        log.info("Login " + Thread.currentThread().getName() + " user " + request.getUsername());
        validationService.validation(request);

        User user = userRespository.findFirstUserByUsername(request.getUsername()).orElseThrow(()->
            new LoginExceptionUnautorized("username tidak valid")
        );

        if(!BCrypt.checkpw(request.getPassword(),user.getPassword())){
            new LoginExceptionUnautorized("password tidak valid");
        }

        String token = UUID.randomUUID().toString();
        user.setToken(token);
        userRespository.save(user);

        Cookie cookie = new Cookie("TOKEN",token);
        cookie.setMaxAge(3600);
        cookie.setPath("/user");
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setCookie(cookie);

        if(user.getName() != null){
            userLoginResponse.setName(user.getName());
        }else {
            userLoginResponse.setName(user.getUsername());
        }
        return userLoginResponse;
    }

    @Transactional(readOnly = true)
    public UserDTO profile(Token token){
        log.info("profile " + Thread.currentThread().getName() + " user " + token.getToken());
        User user = userRespository.findFirstUserByToken(token.getToken()).orElseThrow(()->
              new UnautorizedUserException("user tidak valid login ulang ")
        );
        UserDTO userDTO = new UserDTO();

        if(user.getName() != null ){
            userDTO.setName(user.getName());
        } else if (user.getPhone() != null) {
            userDTO.setPhone(user.getPhone());
        } else if (user.getAddress() != null) {
            userDTO.setAddress(user.getAddress());
        }else {
            userDTO.setName(user.getUsername());
        }
        return userDTO;
    }

    @Transactional
    public void AddTodo(UserAddTodoRequest request,  Token token){
        log.info("add todo " + Thread.currentThread().getName() + " user " + token.getToken());
        validationService.validation(request);

        User user = userRespository.findFirstUserByToken(token.getToken()).orElseThrow(()->
                new UnautorizedUserException("gagal menambah todo user tidak dikenali")
        );

        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDeskripsi(request.getDekspripsi());
        todo.setUser(user);
        todo.setCratedAt(LocalDateTime.now());
        todo.setComplate(false);

        todoRespository.save(todo);
    }

    @Transactional
    public void UpdateTodo(UserUpdateTodoRequest request, Token token){
        log.info("update todo " + Thread.currentThread().getName() + " user " + token.getToken());
        validationService.validation(request);

        Todo tode =  todoRespository.findById(request.getId()).orElseThrow(()->
               new NoSuchElementException("todo yang di update tidak ditemukan")
        );

        if(request.getTitle() != null){
            tode.setTitle(request.getTitle());
            tode.setUpdateAt(LocalDateTime.now());
        } else if (request.getDeskripsi() != null) {
            tode.setDeskripsi(request.getDeskripsi());
            tode.setUpdateAt(LocalDateTime.now());
        } else if (request.getComplate() != null){
            tode.setComplate(request.getComplate());
            tode.setUpdateAt(LocalDateTime.now());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"tidak ada data yang update");
        }

        todoRespository.save(tode);

    }

    @Transactional(readOnly = true)
    public List<Todo> GetAllTodo(Token token){

        List<Todo> todos = todoRespository.findAllTodoById(token.getId()).orElseThrow(()->
                new NoSuchElementException("anda tidak memiliki aktifitas")
        );

        return todos;
    }

    @Transactional
    public void deleteTodo( Integer id, Token token){

        if(Objects.isNull(id)){
            throw new IllegalArgumentException("masukan id todo yang ingin dihapus");
        }

       Todo todo =  todoRespository.findTodoByUser(token.getId(),id).orElseThrow( ()->
                new NoSuchElementException("gagal mengahapus todo tidak di temukan")
        );

        todoRespository.delete(todo);
    }
}
