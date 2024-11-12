//Task 1
//Из списка целых чисел выделите те значения, которые больше 10; отсортируйте эти значения по значению последней цифры в числе и выведите результат на экране
package homework_44;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task_1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(2, 5, 56, 32, 12, 29, 24, 77);
        System.out.println(sortIntegers(integers));

    }

    private static List<Integer> sortIntegers(List<Integer> integers) {

        return integers.stream()
                .filter(integer -> integer > 10)
                .sorted(Comparator.comparingInt(n -> n % 10))
                .collect(Collectors.toList());
    }
}
