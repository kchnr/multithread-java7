package syncWaitNotify;

import org.junit.Before;
import org.junit.Test;

public class TheTestTest {
    SyncWaitNotify classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new SyncWaitNotify();
    }

    @Test
    public void thread1() throws Exception {
        classUnderTest.thread1();
    }

}
