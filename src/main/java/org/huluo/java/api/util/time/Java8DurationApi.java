package org.huluo.java.api.util.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * {@link Duration}这个类象征着一段时间差,一段时间差值
 */
public class Java8DurationApi {

    public static void main(String[] args) {

        new Java8DurationApi().java8DurationApi();
    }

    public void java8DurationApi() {
        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );

        System.out.println("================================");
        LocalTime startLocalTime = LocalTime.of(10, 50, 55);
        LocalTime endLocalTime = LocalTime.of(11, 59, 57);

        Duration localTimeDuration = Duration.between(startLocalTime, endLocalTime);
        System.out.println(localTimeDuration.toDays());
        System.out.println(localTimeDuration.toHours());
        System.out.println(localTimeDuration.toMinutes());
        System.out.println(localTimeDuration.getSeconds());
        System.out.println("========================================");

        LocalTime beginLocalTime = LocalTime.of(11, 20, 20);
        LocalTime stopLocalTime = LocalTime.of(12, 20, 20);

        Duration aliasLocalTimeDuration = Duration.between(beginLocalTime, stopLocalTime);
        System.out.println(aliasLocalTimeDuration.toDays());
        System.out.println(aliasLocalTimeDuration.toHours());
        System.out.println(aliasLocalTimeDuration.toMinutes());
        System.out.println(aliasLocalTimeDuration.getSeconds());
        System.out.println("=======================================");

        Duration result = localTimeDuration.plus(aliasLocalTimeDuration);

        System.out.println(result.toDays());
        System.out.println(result.toHours());
        System.out.println(result.toMinutes());
        System.out.println(result.getSeconds());

    }
}
