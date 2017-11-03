package org.huluo.java.api.util.time;

import java.time.LocalDateTime;

public class Java8LocalDateTime {
    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println(localDateTime.minusDays(2));


    }
}
