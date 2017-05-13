package org.huluo.spring.springpropertyresolvetest;

import org.junit.Test;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;

import java.util.HashMap;
import java.util.Map;

public class SpringPropertyResolveTest {


    @Test
    public void testName() throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("aaa", "AAA");
        PropertySource propertySource = new MapPropertySource("a", map);

        MutablePropertySources propertySources = new MutablePropertySources();

        propertySources.addFirst(propertySource);

        PropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);

        System.out.println(propertyResolver.getProperty("no","默认值哦"));


    }
}
