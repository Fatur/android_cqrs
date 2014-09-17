package id.fatur.cqrs;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
        EditText todo=(EditText)this.getActivity().findViewById(R.id.textToDoEntry);
        todo.setText("testing cqrs dari UI");
        Button add=(Button)this.getActivity().findViewById(R.id.buttonAdd);
        add.callOnClick();
        ListView listTodo=(ListView)this.getActivity().findViewById(R.id.listTodo);
        assertTrue("Todo list exist",listTodo.getCount()>0);
    }

}
