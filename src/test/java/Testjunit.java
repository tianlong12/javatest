
import org.junit.*;
import com.junit.Test;

import static org.junit.Assert.assertEquals;

/** com.junit;
* JunitTest Tester.
*
* @author <Authors name>
* @since <pre>十月 16, 2017</pre>
* @version 1.0
*/
public class Testjunit {
  Test test=new Test();

@Before
public void before() throws Exception {
  System.out.println("start");
}

@After
public void after() throws Exception {
  System.out.println("end");
}

/**
*
* Method: testadd(int i, int i1)
*
*/
@org.junit.Test
public void testTestadd() throws Exception {
 assertEquals(2,test.add(1,1));
}


}