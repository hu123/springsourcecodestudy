package org.huluo.spring.embeddedvalueresolvertest;

import org.junit.Test;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Scope;

public class EmbeddedValueResolverTest {
    @Test
    public void testName() throws Exception {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        EmbeddedValueResolver embeddedValueResolver = new EmbeddedValueResolver(defaultListableBeanFactory);

        System.out.println(embeddedValueResolver.resolveStringValue("helloworld"));


    }
}
