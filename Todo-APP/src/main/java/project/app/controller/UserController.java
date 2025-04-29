package project.app.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import project.app.entity.Todo;
import project.app.entity.User;
import project.app.model.*;
import project.app.service.UserService;

import java.util.List;
import java.util.concurrent.*;

@RestController
@RequestMapping(path = "/TodoApp")
public class UserController {

    private UserService service;

    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    protected ResponseEntity<String> register(@RequestBody UserRegisterRequest userRegisterRequest){
        service.register(userRegisterRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Berhail Register");
    }

    @PostMapping(
            path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    protected ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest, HttpServletResponse response) {
        UserLoginResponse login = service.login(userLoginRequest);
        response.addCookie(login.getCookie());
        return ResponseEntity.status(HttpStatus.OK).body(login);
    }

    @GetMapping(
            path = "/user/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    protected ResponseEntity<UserDTO> userProfile(Token token) {
        return ResponseEntity.status(HttpStatus.OK).body(service.profile(token));
    }

    @PostMapping(
            path = "/user/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    protected ResponseEntity<String> addTodo(@RequestBody UserAddTodoRequest request, Token token){
        service.AddTodo(request,token);
        return ResponseEntity.status(HttpStatus.OK).body("Berhasil menabahkan todo");
    }

    @PatchMapping(
            path = "/user/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    protected ResponseEntity<String> udpateTodo(@RequestBody UserUpdateTodoRequest request, Token token){
        service.UpdateTodo(request,token);
        return ResponseEntity.status(HttpStatus.OK).body("berhasil update");
    }

    @GetMapping(
            path = "/user/todos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    protected ResponseEntity<List<Todo>> viewTodo(Token token)  {
        return ResponseEntity.status(HttpStatus.OK).body(service.GetAllTodo(token));
    }

    @DeleteMapping(
            path = "/user/delete/{id}"
    )
    protected ResponseEntity<String> deleteTodo(@PathVariable("id")Integer id, Token token){
        service.deleteTodo(id,token);
        return ResponseEntity.status(HttpStatus.OK).body("todo berhasil di hapus");
    }


    
}
