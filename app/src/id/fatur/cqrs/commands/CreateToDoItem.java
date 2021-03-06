package id.fatur.cqrs.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by Hp on 9/10/14.
 */
public class CreateToDoItem {
    @TargetAggregateIdentifier
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
