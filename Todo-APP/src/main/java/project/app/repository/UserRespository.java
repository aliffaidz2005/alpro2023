package project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.app.entity.User;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

    Optional<User> findFirstUserByUsernameAndPassword(String username, String password);

    Optional<User> findFirstUserByToken(String token);

    Optional<User> findFirstUserByUsername(String username);
}
