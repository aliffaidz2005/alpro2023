package project.app.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.app.entity.Address;
import project.app.entity.Todo;
import project.app.entity.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private TodoRespository respository;

    @BeforeEach
    void setUp() {
       // userRespository.deleteAll();
    }

    @Test
    void add(){

    }

}
