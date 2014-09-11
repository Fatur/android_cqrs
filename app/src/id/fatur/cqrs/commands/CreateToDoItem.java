package id.fatur.cqrs.commands;

/**
 * Created by Hp on 9/10/14.
 */
public class CreateToDoItem {
    private final String todoId;
    private final String description;

    public CreateToDoItem(String todoId, String description) {

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
