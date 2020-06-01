package java8.lesson5_date_time_collections.date;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class A_2_Java8_Datetime {

    public static void main(String[] args) {
        //a_1_demoInstnt();
        //  a_2_demoTemporalAccessor();
      //  a_3_demoTemporal();
     //   a_4_demoLocalDate();
       // a_5_demoLocalTime();
    }

    private static void a_1_demoInstnt() {
        Instant instant = Instant.now();

        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());
        Instant instant1 = Instant.ofEpochSecond(12);
    }

    private static void a_2_demoTemporalAccessor() {
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getLong(ChronoField.INSTANT_SECONDS));
        var field = ChronoField.MONTH_OF_YEAR;

        if (instant.isSupported(field)) {
            System.out.println(instant.getLong(field));
        } else {
            System.out.println("Not 'MONTH_OF_YEAR' supported ");
        }
    }

    private static void a_3_demoTemporal() {
        Temporal t1 = Instant.now();
        Temporal t2 = t1.plus(1, ChronoUnit.DAYS);
        System.out.println(t1);
        System.out.println(t2);
    }

    private static void a_4_demoLocalDate() {
        LocalDate date = LocalDate.of(2000, 11, 20);
        System.out.println(date.getYear());
        System.out.println(date.get(ChronoField.YEAR));

        Month month = date.getMonth();
        System.out.println(month);
        System.out.println(month.getValue());
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);
    }

    private static void a_5_demoLocalTime(){
        LocalTime time = LocalTime.of(19, 2, 20);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());

        time = LocalTime.parse("11:45:56");
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
    }

    private static void a_6_demoZoneDateTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Moscow"));
    }
    private static void a_6_demoLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
    }
}
