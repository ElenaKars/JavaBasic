//Task 3
//Имеется список целых чисел.
//
//Необходимо отфильтровать этот список, оставив только чётные числа,
// затем каждое число умножить на 2, и собрать результат в новый список

package homework_44;

import java.util.List;
import java.util.stream.Collectors;

public class Task_3 {
    public static void main(String[] args) {
        List<Integer> ints = List.of(2, 6, 33, 22, 55, 12, 14, 18, 100, 0);
        System.out.println(getFilteredList(ints));
    }

    private static List<Integer> getFilteredList(List<Integer> ints) {
        return ints.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }
}
