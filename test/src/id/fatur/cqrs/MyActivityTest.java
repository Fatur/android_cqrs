package id.fatur.cqrs;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import org.axonframework.test.Fixtures;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 *
 * -e class id.fatur.cqrs.MyActivityTest \
 * id.fatur.cqrs.tests/android.test.InstrumentationTestRunner
 */
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {

    public MyActivityTest(String name) {
        super(MyActivity.class);
        setName(name);
    }

    @SmallTest
    public void testMainActivity(){
        Fixtures.newGivenWhenThenFixture(ToDoItem.class);
        assertEquals(0,1);

    }

}
