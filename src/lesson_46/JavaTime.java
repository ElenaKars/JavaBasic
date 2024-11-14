package lesson_46;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JavaTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("now: " + date);

        LocalDate tomorrow = date.plusDays(1);
        System.out.println("tomorrow: " + tomorrow);

        System.out.println("date.plusWeeks(4): " + date.plusWeeks(4));
        System.out.println("yesterday: " + date.minusDays(1));

        LocalDate date1 = LocalDate.of(2002, 2, 15);
        System.out.println(date1);
        LocalDate date2 = LocalDate.of(2002, Month.FEBRUARY, 15);
        System.out.println("можно использовать enum month: "+ date2);

        System.out.println("у объекта LocalDate есть геттеры " + date2.getYear() + " " + date2.getMonth() + " " +  date2.getMonthValue());
        System.out.println("число: " + date2.getDayOfMonth() + " " + "день недели: "  + date2.getDayOfWeek() + " " + "день года: " + date2.getDayOfYear());
        DayOfWeek dayOfWeek = date2.getDayOfWeek();
        System.out.println("dayOfWeek.getValue(): " + dayOfWeek.getValue());
        System.out.println("количество дней в месяце: " + date2.lengthOfMonth() + "; дней в году: " + date2.lengthOfYear());

        Month[] months = Month.values();
        for(Month month : months) {
            System.out.println(month);
        }

        String dateString = "2000-10-25"; // формат ГГГГ-ММ-ДД
        LocalDate date3 = LocalDate.parse(dateString);
        System.out.println(date3.getDayOfMonth() + "-" + date3.getMonthValue() + "-" + date3.getYear() + "-" + date3.getDayOfWeek());

        System.out.println("\n======Local Time=====");
        LocalTime time = LocalTime.now();
        System.out.println("time: " + time);
        LocalTime time1 = LocalTime.of(21, 33);
        time1 = LocalTime.of(21, 33, 44, 54234);
        System.out.println(time1);

        System.out.println("time + 1 hour: " + time.plusHours(1));
        System.out.println(time.minusMinutes(65));
        System.out.println(time.minusSeconds(389));

        System.out.println("getters: hours: " + time.getHour() + "; minutes: " + time.getMinute() + "; seconds: " + time.getSecond() + "; nanoseconds: " + time.getNano());
        String timeStr = "12:13:46";
        LocalTime parseTime = LocalTime.parse(timeStr);
        System.out.println(parseTime);

        System.out.println("\n=========LocalDateTime==========");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate = LocalDate.of(2011, Month.AUGUST, 15);
        LocalTime localTime = LocalTime.of(15, 31, 59);
        LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(dateTime);
        dateTime = LocalDateTime.of(2024, 12, 31, 23,59);
        System.out.println(dateTime.getDayOfWeek());
        System.out.println(dateTime.getDayOfWeek().getValue());

        System.out.println("dateTime.plusHours(1): " + dateTime.plusHours(1));
        System.out.println("dateTime.minusYears(1): " + dateTime.minusYears(1));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime: " + zonedDateTime);

        LocalDate date4 = LocalDate.of(1988, 9, 2);
        LocalDate date5 =LocalDate.of(1988, 6, 2);

        boolean isAfter = date4.isAfter(date5);
        boolean isBefore = date5.isBefore(date4);
        System.out.println("date4 is after date5: " + isAfter);
        System.out.println("date5 is before date4: " + isBefore);

        System.out.println("date4.equals(date5): " + date4.equals(date5));

        long daysBetween = date4.until(date5, ChronoUnit.DAYS);
        System.out.println(daysBetween);

        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime dateTime2 = dateTime1.plusDays(15);
        System.out.println(dateTime2.until(dateTime1, ChronoUnit.DAYS));

        LocalDateTime dateTime3 = dateTime1.minus(10, ChronoUnit.DAYS);
        LocalDateTime dateTime4 = dateTime1.plus(5, ChronoUnit.WEEKS);

        System.out.println(dateTime3);
        System.out.println(dateTime4);

        long daysBetween2 = ChronoUnit.DAYS.between(dateTime3, dateTime4);
        System.out.println(daysBetween2);
        System.out.println(ChronoUnit.HOURS.between(dateTime3, dateTime4));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        String formatedDate = now.format(formatter);
        System.out.println("StringDate: " + formatedDate);



    }
}
