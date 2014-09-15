package id.fatur.cqrs.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by Hp on 9/11/14.
 */
public class MarkCompleted {
    @TargetAggregateIdentifier
    private final String todoId;

    public MarkCompleted(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
