//Task 2 * ОПЦИОНАЛЬНО
//Напишите MyComparator, реализующий Comparator с методом сравнения для сортировки массива целых чисел в следующем порядке:
//
//Четные целые числа должны идти перед нечетными числами
//Integer[] integers = { 1, 6, 5, 4, 7, 8, 9, 2, 7, 3 };
//// Сортировка массива с использованием компаратора
//[2, 4, 6, 8, 1, 3, 5, 7, 7, 9] // Outpur
package homework_38.task_2;

import java.util.Arrays;
import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer int1, Integer int2) {
       if(int1 % 2 == 0 && int2 % 2 != 0) {
           return -1;
       } else if(int1 % 2 != 0 && int2 % 2 == 0) {
            return 1;
        } else {
           return Integer.compare(int1, int2);
       }
       }

public static void main(String[] args) {
    Integer[] integers = { 1, 6, 5, 4, 7, 8, 9, 2, 7, 3 };

    Arrays.sort(integers, new MyComparator());
    System.out.println(Arrays.toString(integers));
    }
}


