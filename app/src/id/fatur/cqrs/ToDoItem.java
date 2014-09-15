package id.fatur.cqrs;

import id.fatur.cqrs.commands.CreateToDoItem;
import id.fatur.cqrs.commands.MarkCompleted;
import id.fatur.cqrs.events.ToDoItemCompleted;
import id.fatur.cqrs.events.ToDoItemCreated;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * Created by Hp on 9/10/14.
 */
public class ToDoItem extends AbstractAnnotatedAggregateRoot {
    @AggregateIdentifier
    private String id;
    public ToDoItem(){}
    @CommandHandler
    public ToDoItem(CreateToDoItem command){
        apply(new ToDoItemCreated(command.getTodoId(),command.getDescription()));
    }
    @EventHandler
    public void on(ToDoItemCreated event){
        System.out.println("Got New.");
        this.id=event.getTodoId();
    }

    @CommandHandler
    public void markCompleted(MarkCompleted command){
        System.out.println("Mark complete.");
        apply(new ToDoItemCompleted(command.getTodoId()));
    }
    /*
    @EventHandler
    public void on(ToDoItemCompleted cmd){
        System.out.println("Got completed.");
    }*/
}
