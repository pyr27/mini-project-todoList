package side_pj.side_project.todoList;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getTodosByMember(Long memberId) {
        return todoRepository.findByMemberId(memberId);
    }

    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public void deleteTodoItem(Long id) {
        todoRepository.deleteById(id);
    }

    public TodoItem updateTodoItem(Long id, TodoItem updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setTime(updatedTodo.getTime());
            todo.setDone(updatedTodo.isDone());
            return todoRepository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo not found"));
    }
}
