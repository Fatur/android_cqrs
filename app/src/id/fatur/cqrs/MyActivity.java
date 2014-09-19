package id.fatur.cqrs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {
    private List<String> list=new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private CommandGateway commandGateway=null;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpCommandGateWay();
        setUpTheList();
        Button addItem=(Button)this.findViewById(R.id.buttonAdd);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTodoToList();
            }
        });

    }

    private void setUpCommandGateWay() {
        CommandBus commandBus = new SimpleCommandBus();

        commandGateway = new DefaultCommandGateway(commandBus);

        EventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("./eventsRepo")));

        EventBus eventBus = new SimpleEventBus();

        EventSourcingRepository repository = new EventSourcingRepository(ToDoItem.class, eventStore);
        repository.setEventBus(eventBus);

        AggregateAnnotationCommandHandler.subscribe(ToDoItem.class, repository, commandBus);

        AnnotationEventListenerAdapter.subscribe(new ToDoReport(this.list), eventBus);
    }

    private void setUpTheList() {
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        ListView listView=(ListView)findViewById(R.id.listTodo);
        listView.setAdapter(adapter);
    }

    private void addTodoToList() {
        EditText edit=(EditText)findViewById(R.id.textToDoEntry);
        this.list.add(edit.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
