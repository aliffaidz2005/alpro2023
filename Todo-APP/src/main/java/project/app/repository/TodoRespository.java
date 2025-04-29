package project.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.app.entity.Todo;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRespository extends JpaRepository<Todo, Integer> {

    @Query(value = "SELECT * FROM todos WHERE user_id = :userId", nativeQuery = true)
    Optional<List<Todo>> findAllTodoById(@Param("userId") Integer id);

    @Query(value = "SELECT * FROM todos WHERE user_id = :userId AND id = :id", nativeQuery = true)
    Optional<Todo> findTodoByUser(@Param("userId") Integer userId, @Param("id") Integer id);

}
