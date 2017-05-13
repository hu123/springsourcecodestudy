import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;
import java.util.Iterator;

class Test1<E> {

    private E e;

}

public class SpringResolvableTypeTest {
    public static void main(String[] args) {

        ResolvableType resolvableType1 = ResolvableType.forClass(Test1.class);


        System.out.println(resolvableType1.getGenerics()[0].getType());


//        System.out.println(resolvableType1.getGenerics().length);

        Arrays.stream(resolvableType1.getGenerics()).forEach(resolvableType -> {
            System.out.println(resolvableType.getType());
        });
    }
}
