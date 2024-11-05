//Task 1
//Напишите метод, который принимает на вход две реализации интерфейса List.
//
//Метод должен возвращать список состоящий из элементов, которые присутствуют в обеих коллекциях.
package homework_39;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task_1 {
    public static void main(String[] args) {
        Collection<String> colA = new ArrayList<>(List.of("Java", "Python", "C++", "Ruby", "globe"));
        Collection<String> colB = new ArrayList<>(List.of("JavaScript", "Java", "peace", "C++"));

        System.out.println("colA: " + colA);
        System.out.println("colB: " + colB);

        colA.retainAll(colB);
        System.out.println("colA.retainAll(colB): " + colA);

    }
}
