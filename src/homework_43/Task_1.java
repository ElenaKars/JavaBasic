//Task 1
//Напишите метод, принимающий список чисел и возвращающий новый, отфильтрованный список.
//
//В новом списке должны быть только те числа из старого списка, которые соответствуют всем условиям: четные, больше 10 и меньше 100
//
//Для фильтрации используйте Stream API
package homework_43;

import java.util.List;
import java.util.stream.Collectors;


public class Task_1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 69, 30, 50, -10, -23, -6, 28, 46);
        newCollection(integers);
    }

    private static void newCollection(List<Integer> integers) {
        List<Integer> newCollection = integers.stream()
                .filter(i -> i % 2 == 0 && i > 10 && i < 100)
                .collect(Collectors.toList());
        System.out.println(newCollection);
    }

}
