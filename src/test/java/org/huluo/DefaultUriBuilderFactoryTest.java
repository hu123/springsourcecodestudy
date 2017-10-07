package org.huluo;

import org.junit.Test;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

import java.util.HashMap;
import java.util.Map;

public class DefaultUriBuilderFactoryTest {

    @Test
    public void testUriTemplateHandlerExpandApi() {
        UriTemplateHandler uriTemplateHandler = new DefaultUriBuilderFactory();
        System.out.println(uriTemplateHandler);
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("name", "hu");
        paramsMap.put("value", "luo");
        System.out.println(uriTemplateHandler.expand("http://localhost/{name}/{value}", paramsMap));
        System.out.println(uriTemplateHandler.expand("http://localhost/{aaa}", "NoNoNo"));
    }
}
