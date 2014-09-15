package id.fatur.cqrs.unit;

import android.test.suitebuilder.annotation.SmallTest;
import id.fatur.cqrs.ToDoItem;
import junit.framework.TestCase;
import org.axonframework.test.Fixtures;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class ExampleTest extends TestCase {
    @SmallTest
    public void testMainActivity(){
        Fixtures.newGivenWhenThenFixture(ToDoItem.class);
        assertEquals(0,1);

    }
}
