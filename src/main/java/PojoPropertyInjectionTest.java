import org.huluo.spring.ioc.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PojoPropertyInjectionTest {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/pojoPropertiesInjection.xml");

        Student student = applicationContext.getBean("student", Student.class);

        System.out.println(student);


    }
}
