//Task 2
//Дан список строк.
//
//Используя Stream API, отфильтруйте строки, которые начинаются на определенную букву (например, "A"), удалите дубликаты и отсортируйте их в алфавитном порядке.
//
//Результат сохраните в новый список строк.
package homework_43;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task_2 {
    public static void main(String[] args) {
        List<String> strings = List.of("Используя", "Stream", "отфильтруйте", "строки", "которые", "начинаются", "на", "определенную", "букву");
        sortStrings(strings, 's');
    }

    private static void sortStrings(List<String> strings, char charStart) {
        List<String> newCollect = strings.stream()
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(String.valueOf(charStart)))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(newCollect);
    }

}
