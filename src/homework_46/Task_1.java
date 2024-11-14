//Task 1
//Получить и вывести на экран:
//текущую дату
//текущий год, месяц и день
//Создать дату, например Ваш день рождения и вывести на экран
//Создать две даты и проверить на равенство
//Получить и вывести на экран:
//текущее время
//текущее время + 3 часа
//Создать дату:
//которая на неделю позже сегодняшней
//которая была на год раньше сегодняшней используя метод minus
//которая на год позже сегодняшней
//tomorrow и yesterday и проверить находятся ли они до или после сегодняшней
package homework_46;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task_1 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate: " + localDate);
        System.out.println("текущий год: " + localDate.getYear());
        System.out.println("текущий месяц: " + localDate.getMonth());
        System.out.println("текущий день:" + localDate.getDayOfMonth());

        LocalDate myBirth = LocalDate.of(1988, 9, 2);
        System.out.println(myBirth);

        LocalDate date = LocalDate.of(1988, 9, 2);
        LocalDate date1 = LocalDate.of(1988, 10, 2);

        System.out.println("date1.equals(date): " + date1.equals(date));

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        System.out.println(time.plusHours(3));
        System.out.println(time.plus(3, ChronoUnit.HOURS));

        LocalDate inOneWeek = localDate.plusWeeks(1);
        System.out.println("inOneWeek: " + inOneWeek);
        System.out.println("localDate.minusYears(1): " + localDate.minusYears(1));
        System.out.println("localDate.plusYears(1): " + localDate.plusYears(1));
        System.out.println("yesterday: " + localDate.minusDays(1));
        System.out.println("tomorrow: " + localDate.plusDays(1));
        System.out.println("yesterday is after tomorrow: " + localDate.minusDays(1).isAfter(localDate.plusDays(1)));

        System.out.println("yesterday is before tomorrow: " + localDate.minusYears(1).isBefore(localDate.plusDays(1)));
    }
}
