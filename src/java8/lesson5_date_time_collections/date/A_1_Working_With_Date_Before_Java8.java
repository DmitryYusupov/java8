package java8.lesson5_date_time_collections.date;

import java.util.Calendar;
import java.util.Date;

public class A_1_Working_With_Date_Before_Java8 {

    public static void main(String[] args) {
        //a_1_Date();
      //a_2_demoCalendar();
    }

    private static void a_1_Date() {
        Date date = new Date();
        date.setDate(7);
        date.setHours(20);
        System.out.println(date);
        //date.getTime();
    }

    private static void a_2_demoCalendar() {
        var date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        System.out.println(new Date(calendar.getTimeInMillis()));
    }
}
