package id.fatur.cqrs.events;

/**
 * Created by Hp on 9/10/14.
 */
public class ToDoItemCreated {
    private final String todoId;
    private final String description;

    public ToDoItemCreated(String todoId, String description) {

        this.todoId = todoId;
        this.description = description;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }
}
