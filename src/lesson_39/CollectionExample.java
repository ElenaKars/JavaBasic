package lesson_39;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionExample {
    public static void main(String[] args) {
        //интерфейс Collection, который гарантирует наличие базовых методов для всех расширяющих его интерфейсов
        //это позволяет единообразно обрабатывать различные типы коллекций

        //создаем коллекцию строк

        Collection<String> strings = new ArrayList<>();
        System.out.println("strings.size(): " + strings.size());

        System.out.println("strings.isEmpty(): " + strings.isEmpty());

        strings.add("Java");
        strings.add("Python");

        System.out.println(strings);

        Collection<Integer> integers = List.of(0, 1, 2, 3, 4, 5);
        System.out.println(integers);

        strings.addAll(List.of("gddg", "fhfj", "fggfh"));
        System.out.println(strings);
        strings.add("end");
        System.out.println(strings);

        Collection<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(0, 1, 2, 3, 4, 5, 1));
        System.out.println("numbers: " + numbers);
        numbers.removeAll(List.of(1, 0, 3));
        System.out.println(" numbers.removeAll(List.of(1, 2, 3)): " + numbers);

        Collection<Integer> colA = new ArrayList<>();
        Collection<Integer> colB = new ArrayList<>();

        colA.addAll(List.of(10, 20, 30, 20, 40, 50));
        colB.addAll(List.of(20, 30, 40));
        System.out.println("colA: " + colA);
        System.out.println("colB: " + colB);

        colA.retainAll(colB);
        System.out.println("colA.retainAll(colB): " + colA);

        System.out.println("colA.remove(100): " + colA.remove(100));
        System.out.println("colA.remove(40): " + colA.remove(40));
        System.out.println("colA: " + colA);

    }
}
