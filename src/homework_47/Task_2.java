//Task 2 Опционально
//В рамках освоения возможностей Java Time API предлагаем вам выполнить следующие задания:
//
//2.1: Парсинг и анализ даты и времени
//У вас есть строка: "15-12-2022 20-46".
//
//Используя возможности Java Time API, выполните следующие действия:
//Распарсите данную строку в объект LocalDateTime.
//После успешного парсинга выведите отдельно:
//Месяц
//День
//Час

//2.2: Определение дня недели и расчёт интервала между датами
//Вторая строка для работы: "30/01/23 1:47" (обратите внимание, что 23 — это год).
//
//Ваши задачи:
//
//Определите, на какой день недели приходится эта дата.
//Вычислите количество дней между первой и второй датами из заданий.
//P.S. :
//
//Используйте соответствующие классы и методы из Java Time API для парсинга и обработки дат и времени.
//При решении обращайте внимание на формат входных строк и используйте соответствующие форматеры.
package homework_47;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task_2 {
    public static void main(String[] args) {
        String str = "15-12-2022 20-46";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
        LocalDateTime parseDate = LocalDateTime.parse(str, formatter);
        System.out.println("Месяц: " + parseDate.getMonth());
        System.out.println("День: " + parseDate.getDayOfWeek() + " | число: " + parseDate.getDayOfWeek().getValue());
        System.out.println("Час: " + parseDate.getHour());

        String dateStr1 = "30/01/23 1:47";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yy H:mm");
        LocalDateTime parseDate1 = LocalDateTime.parse(dateStr1, formatter1);
        System.out.println(parseDate1.getDayOfWeek());
        System.out.println("Days between: " + ChronoUnit.DAYS.between(parseDate, parseDate1));
    }
}
