import org.springframework.core.ResolvableType;

import java.util.Arrays;

public class SpringResolvableTypeTest3 {
    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forInstance("helloworld");

        ResolvableType[] resolvableTypes = resolvableType.getInterfaces();
        Arrays.stream(resolvableTypes).forEach(resolvableType1 -> System.out.println(resolvableType1));
    }
}
