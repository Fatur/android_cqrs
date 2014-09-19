package id.fatur.cqrs;

import id.fatur.cqrs.events.ToDoItemCompleted;
import id.fatur.cqrs.events.ToDoItemCreated;
import org.axonframework.eventhandling.annotation.EventHandler;

import java.util.List;


/**
 * Created by Hp on 9/12/14.
 */
public class ToDoReport {
    private String todoId;
    private String description;
    private boolean status;
    private List<String> list;
    public ToDoReport(List<String> list) {
        this.list=list;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleteStatus() {
        return status;
    }

    @EventHandler
    public void handle(ToDoItemCreated event){
        System.out.println("We've got something to do: " + event.getDescription() + " (" + event.getTodoId() + ")");
        todoId=event.getTodoId();
        description=event.getDescription();
        status=false;
        list.add(event.getDescription());
    }
    @EventHandler
    public void handle(ToDoItemCompleted event){
        System.out.println("we've completed a task: " + event.getTodoId());
        this.status=true;
    }
}
