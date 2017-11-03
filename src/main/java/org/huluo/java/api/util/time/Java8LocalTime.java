package org.huluo.java.api.util.time;

import java.time.LocalTime;

public class Java8LocalTime {
    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.ofSecondOfDay(4503);

        System.out.println(localTime1);
    }
}
