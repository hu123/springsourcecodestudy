package org.huluo.java.api.util.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Java8Instant {

    public static void main(String[] args) {
        new Java8Instant().java8InstantAPI();
    }
    public void java8InstantAPI() {
        //将java.util.Date转换为Instant
        Instant instant = Instant.ofEpochMilli(new Date().getTime());
        //从字符串类型中创建Instant类型的时间
        instant = Instant.parse("1995-10-23T10:12:35Z");
        System.out.println(instant);


        Instant result1 = instant.minus(5, ChronoUnit.DAYS); // Option 1　方法1

        System.out.println(result1);

        Instant result2 = result1.minus(Duration.ofDays(5));

        System.out.println(result2);

        System.out.println(result1.isAfter(result2));

        System.out.println(instant.isBefore(result1));
    }
}
