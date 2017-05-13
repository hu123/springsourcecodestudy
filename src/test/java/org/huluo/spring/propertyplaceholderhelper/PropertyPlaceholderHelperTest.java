package org.huluo.spring.propertyplaceholderhelper;
import org.junit.Test;
import org.springframework.util.PropertyPlaceholderHelper;

public class PropertyPlaceholderHelperTest {
    @Test
    public void testName() throws Exception {
        PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("${", "}");

        System.out.println(propertyPlaceholderHelper);
    }
}
