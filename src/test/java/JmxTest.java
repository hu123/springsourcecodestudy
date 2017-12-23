import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:mbean.xml")
public class JmxTest {

    @Test
    public void testAsync() throws InterruptedException {
        TimeUnit.HOURS.sleep(1);
    }

}