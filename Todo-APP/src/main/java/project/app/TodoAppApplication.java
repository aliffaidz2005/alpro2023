package project.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
		"project.app.controller",
		"project.app.service",
		"project.app.repository",
		"project.app.util",
		"project.app.exceptionHandler",
		"project.app.security",
		"project.app"
})
public class TodoAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

}
