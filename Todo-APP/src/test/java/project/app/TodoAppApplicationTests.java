package project.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.app.entity.Todo;
import project.app.entity.User;
import project.app.repository.TodoRespository;
import project.app.repository.UserRespository;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class TodoAppApplicationTests {

	@Autowired
	private UserRespository userRespository;
	@Autowired
	private TodoRespository todoRespository;

	@Test
	void contextLoads() {
		User byId = userRespository.findById(13).get();

		Todo todo = new Todo();
		todo.setUser(byId);
		todo.setTitle("Belajar java python");
		todo.setDeskripsi("buku java dasar yang lengkap untuk pemula");
		todo.setComplate(false);
		todoRespository.save(todo);
	}

}
