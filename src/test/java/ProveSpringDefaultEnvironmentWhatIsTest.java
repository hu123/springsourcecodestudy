import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 验证Spring的默认的环境类是{@link org.springframework.core.env.StandardEnvironment}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class ProveSpringDefaultEnvironmentWhatIsTest {
    @Autowired
    private Environment environment;
    @Test
    public void getSpringDefaultEnvironment() throws Exception {
        System.out.println("我看下" + environment.getClass());
    }
}
@Configuration
class SpringConfiguration{
}
