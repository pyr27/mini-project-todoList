package side_pj.side_project.todoList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 특정 회원의 Todo 목록 조회
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<TodoItem>> getTodosByMember(@PathVariable Long memberId) {
        List<TodoItem> todos = todoService.getTodosByMember(memberId);
        return ResponseEntity.ok(todos);
    }

    // Todo 생성
    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem todoItem) {
        TodoItem savedTodo = todoService.createTodoItem(todoItem);
        return ResponseEntity.ok(savedTodo);
    }

    // Todo 수정
    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodo(@PathVariable Long id, @RequestBody TodoItem updatedTodo) {
        TodoItem todo = todoService.updateTodoItem(id, updatedTodo);
        return ResponseEntity.ok(todo);
    }

    // Todo 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return ResponseEntity.noContent().build();
    }
}
