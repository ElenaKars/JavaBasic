package lesson_43;

import java.lang.invoke.ConstantBootstraps;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuntionalInterfaces {
    public static void main(String[] args) {

        //Consumer<T> - выполняет операцию над объектом, не возвращая никакого результата
        //void accept(T t)

        Consumer<String> example = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
        Consumer<String> printConsumer = str -> System.out.println(str);
        printConsumer.accept("Hello, World");
        printConsumer.accept("Java");

        //составной интерфейс
        Consumer<String> consumer1 = str -> System.out.println("1. " + str.length());
        Consumer<String> consumer2 = string -> System.out.println("2. " + string + "!");
        Consumer<String> resultConsumer = consumer1.andThen(consumer2);
        resultConsumer.accept("test");
        System.out.println("\n========Predicate=====\n");

        //Predicate<T> предназначен для представления простых функций,
        // которые принимают один аргумент типа T и возвращают логическое значение (boolean).
        // Этот интерфейс особенно полезен для фильтрации или проверки соответствия элементов определенным условиям.

        Predicate<String> strPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        //проверяет, что строка не пустая

         Predicate<String> isNoEmpty = str -> !str.isEmpty();
         boolean result = isNoEmpty.test("Hello, World!");
        System.out.println(result);
        System.out.println(isNoEmpty.test(""));
        List<Integer> numbers = new ArrayList<>(List.of(-1, 3, 4, 10, -10, -15, 11, 17, 24));
        //сптсок отрицат чисел
        List<Integer> result1 = filterByPredicate(numbers, i -> i < 0);
        System.out.println(result1);
        List<Integer> result2 = filterByPredicate(numbers, i -> i >= 0);
        System.out.println(result2);
        List<Integer> result3 = filterByPredicate(numbers, i -> i >= 0 && i % 2 ==0);
        System.out.println(result3);
        System.out.println("\n===========\n");

        Predicate<String> isLengthGreat6 = str -> str.length() > 6;
        Predicate<String> isContainsJava = str -> str.contains("Java");
        String test = "Java!";
        Predicate<String> combineString = isLengthGreat6.or(isContainsJava);
        System.out.println(combineString.test(test));
        Predicate<String> negate = isContainsJava.negate();
        System.out.println(negate.test(test));
        System.out.println("\n===========\n");


        Function<String, Integer> integerFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 0;
            }
        };

        Function<String, Integer> function = string -> string.length();
        int length = function.apply("Hello, World!");
        System.out.println("function.apply(\"Hello, World!\"): " + length);

        Function<String, String> toUpperCase = String::toUpperCase;//str.toUpperCase();
        System.out.println(toUpperCase.apply("Test string"));

    }

    //Метод, возврашающий список всех элементов, удовл условиям

    public static List<Integer> filterByPredicate(List<Integer> integers, Predicate<Integer> predicate){
        List<Integer> result = new ArrayList<>();

        for (Integer integer : integers){
            if(predicate.test(integer)){
                result.add(integer);
            }
        }
        return result;
    }
}
