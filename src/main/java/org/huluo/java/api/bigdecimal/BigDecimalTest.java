package org.huluo.java.api.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalTest {
    public static void main(String[] args) {
        //保留2位有效数字
        MathContext mathContext = new MathContext(2);
        BigDecimal bigDecimal = new BigDecimal(100.222, mathContext);
        System.out.println(bigDecimal);

        //保留3位有效数字
        MathContext mathContext1 = new MathContext(3);
        BigDecimal bigDecimal1 = new BigDecimal(10.21, mathContext1);
        System.out.println(bigDecimal1);

    }
}
