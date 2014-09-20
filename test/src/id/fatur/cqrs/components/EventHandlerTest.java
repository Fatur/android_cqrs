package id.fatur.cqrs.components;



import id.fatur.cqrs.ToDoItem;
import id.fatur.cqrs.ToDoReport;
import id.fatur.cqrs.commands.CreateToDoItem;
import id.fatur.cqrs.commands.MarkCompleted;
import junit.framework.TestCase;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Hp on 9/12/14.
 */
public class EventHandlerTest extends TestCase {
    private CommandGateway commandGateway;
    private EventBus eventBus;
    private ToDoReport report;
    private List<String> list;
    @Before
    public void setUp(){
        list=new ArrayList<String>();
        CommandBus commandBus = new SimpleCommandBus();

        commandGateway = new DefaultCommandGateway(commandBus);

        EventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("./eventsRepo")));

        eventBus = new SimpleEventBus();

        EventSourcingRepository repository = new EventSourcingRepository(ToDoItem.class, eventStore);
        repository.setEventBus(eventBus);

        AggregateAnnotationCommandHandler.subscribe(ToDoItem.class, repository, commandBus);
        report=new ToDoReport(list);
        AnnotationEventListenerAdapter.subscribe(report, eventBus);
    }
    @Test
    public void testReportHandler(){


        final String itemId = UUID.randomUUID().toString();
        commandGateway.send(new CreateToDoItem(itemId, "Need to do this"));
        Object o=commandGateway.sendAndWait(new MarkCompleted(itemId));
        assertEquals("TodoId", itemId, report.getTodoId());
        assertEquals("Description","Need to do this",report.getDescription());

        assertTrue("Complete Status", report.getCompleteStatus());
        assertEquals("Inserted String","Need to do this",list.get(0));

    }
}
