package id.fatur.cqrs.unittest;

import id.fatur.cqrs.ToDoItem;
import id.fatur.cqrs.commands.CreateToDoItem;
import id.fatur.cqrs.events.ToDoItemCreated;
import junit.framework.TestCase;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Hp on 9/10/14.
 */

public class ToDoItemTest extends TestCase {
    private FixtureConfiguration fixture;
    @Before
    public void setUp(){
        fixture= Fixtures.newGivenWhenThenFixture(ToDoItem.class);
    }
    @Test
    public void testCreateToDoItem(){
        fixture.given()
                .when(new CreateToDoItem("Todo1","need to implement the aggregate"))
                .expectEvents(new ToDoItemCreated("Todo1","need to implement the aggregate"));
    }
}
