package org.huluo.spring.springapi.springresolvabletype;

import org.springframework.core.ResolvableType;

import java.util.Arrays;

class Test1<E> {

    private E e;

}

public class SpringResolvableTypeTest {
    public static void main(String[] args) {

        ResolvableType resolvableType1 = ResolvableType.forClass(Test1.class);


        System.out.println(resolvableType1.getGenerics()[0].getType());



        Arrays.stream(resolvableType1.getGenerics()).forEach(resolvableType -> {
            System.out.println(resolvableType.getType());
        });
    }
}
