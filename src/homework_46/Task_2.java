//Task 2
//Написать метод, принимающий список из нескольких дат типа LocalDate и возвращающий количество дней между самой ранней и поздней датами в этом списке
package homework_46;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) {
//        List<LocalDate> dates = List.of(LocalDate.of(2011, 9, 11),
//                LocalDate.of(1973, 4, 4),
//                LocalDate.of(1888, 1,1),
//                LocalDate.of(2016, 8, 16),
//                LocalDate.of(2888, 1,1));
        List<LocalDate> dates = null;
        System.out.println("Between minimum and max dates: " + countDaysBetweenDates(dates) + " days");

    }

    private static long countDaysBetweenDates(List<LocalDate> dates) {
        if (dates == null || dates.size() < 2) throw new IllegalArgumentException("The list must include at least 2 dates");
        LocalDate min = LocalDate.now();
        LocalDate max = LocalDate.now();
        for (LocalDate date : dates){
            if(date.isBefore(min)) min = date;
            if(date.isAfter(max)) max = date;
        }
        return min.until(max, ChronoUnit.DAYS);
    }
}
