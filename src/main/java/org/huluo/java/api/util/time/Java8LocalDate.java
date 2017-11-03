package org.huluo.java.api.util.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.Era;

public class Java8LocalDate {
    public static void main(String[] args) {
        new Java8LocalDate().localDate();
    }


    private void localDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        localDate = LocalDate.ofYearDay(2005, 86);
        System.out.println(localDate);

        LocalDate localDate1 = LocalDate.of(2013, Month.AUGUST, 10);

        System.out.println(localDate.getDayOfWeek());


        System.out.println(LocalDate.ofEpochDay(-1));

        System.out.println(localDate1.isBefore(localDate));

        Era era = localDate.getEra();
        System.out.println(era);

    }
}
