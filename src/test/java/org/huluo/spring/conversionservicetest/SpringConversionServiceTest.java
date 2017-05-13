package org.huluo.spring.conversionservicetest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class SpringConversionServiceTest {


    @Test
    public void testName() throws Exception {
        DefaultConversionService serivce = new DefaultConversionService();
        boolean actual = serivce.canConvert(String.class, Boolean.class);
        Assert.assertEquals(true, actual);
        Object acc = serivce.convert("true", Boolean.class);

        System.out.println(acc.getClass().getName());

        System.out.println("================");

        System.out.println(serivce.canConvert(String.class, Object.class));

        System.out.println(serivce.convert(new String(),Object.class).getClass().getName());
    }
}
