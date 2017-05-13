import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test<E> {

    public <M> void sayHello(M t) {
    }

}

public class SpringResolvableTypeTest2 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
        Method method = Test.class.getDeclaredMethod("sayHello",Object.class);

        ResolvableType resolvableType = ResolvableType.forMethodParameter(method, 0);

        Field field = resolvableType.getClass().getDeclaredField("typeProvider");

        field.setAccessible(true);
        System.out.println(field.get(resolvableType));

    }
}
