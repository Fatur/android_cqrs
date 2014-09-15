package id.fatur.cqrs.events;

/**
 * Created by Hp on 9/11/14.
 */
public class ToDoItemCompleted {
    private final String todoId;

    public ToDoItemCompleted(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
