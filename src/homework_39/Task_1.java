//Task 1
//Напишите метод, который принимает на вход две реализации интерфейса List.
//
//Метод должен возвращать список состоящий из элементов, которые присутствуют в обеих коллекциях.
package homework_39;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Task_1 {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 3, 6, 4, 5));
        List<Integer> integers1 = new LinkedList<>(List.of(3, 4, 5, 1, 2, 3, 3));
        System.out.println(intersection(integers, integers1));
        System.out.println(intersection(integers1, integers));

        List<String> strings = new ArrayList<>(List.of("a", "b", "c"));
        List<String> strings1 = new LinkedList<>(List.of("d", "b", "c"));
        System.out.println(intersectionGen(strings, strings1));
        System.out.println(intersectionGen(integers1, integers));



//        Collection<String> colA = new ArrayList<>(List.of("Java", "Python", "C++", "Ruby", "globe"));
//        Collection<String> colB = new ArrayList<>(List.of("JavaScript", "Java", "peace", "C++"));
//
//        System.out.println("colA: " + colA);
//        System.out.println("colB: " + colB);
//
//        colA.retainAll(colB);
//        System.out.println("colA.retainAll(colB): " + colA);


    }

    public static <T> List<T> intersectionGen(List<T> list1, List<T> list2){
        List<T> result = new ArrayList<>(list1);
        result.retainAll(list2);
        return result;
    }
    public static List<Integer>intersection(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>(list1);
        result.retainAll(list2);
        return result;
    }
}
