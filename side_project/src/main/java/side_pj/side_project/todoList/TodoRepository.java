package side_pj.side_project.todoList;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByMemberId(Long memberId);
}
