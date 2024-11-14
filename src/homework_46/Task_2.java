//Task 2
//Написать метод, принимающий список из нескольких дат типа LocalDate и возвращающий количество дней между самой ранней и поздней датами в этом списке
package homework_46;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task_2 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2011, 9, 11);
        LocalDate date = LocalDate.of(1973, 4, 4);
        System.out.println("Days between dates " + date + " and " + date1 + ": " + countDaysBetweenDates(date, date1));

    }

    private static long countDaysBetweenDates(LocalDate date, LocalDate date1) {
        return date.until(date1, ChronoUnit.DAYS);
    }


}
