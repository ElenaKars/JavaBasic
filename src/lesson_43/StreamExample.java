package lesson_43;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
         /*
        Stream api - мощный инструмент, позволяющий обрабатывать наборы данных в декларативном стиле.

        Stream - поток данных, который представляет собой последовательность элементов.
        Поток дает возможность поочередного получения элемента данных для обработки.
        Стрим может быть создан из различных источников (массивы, коллекции и так далее)

        Pipeline - последовательность операций, выполняемых на потоке

        Промежуточные операции (методы) - Это операции, которые преобразуют поток в другой поток (возвращают поток)
        Их может много (больше чем одна)

        Терминальные операции (методы) - Это операции, которые запускают обработку потока и закрывают его.
        После выполнения терминальной операции поток перестает быть доступным для дальнейшей обработки.
        Может быть ТОЛЬКО ОДИН терминальный метод

        Ленивые вычисления
        Стримы не выполняют промежуточные операции, пока на потоке не будет вызван терминальный метод.

        Как создать поток:
        stream() - создание потока из элементов коллекции

         */

        /*
        Промежуточные методы:
        Stream<T> filter(Predicate<T> predicate) - оставляет в потоке только те элементы, для которых предикат вернет true
        Т.е. оставляет элементы, удовлетворяющие условию (отбрасывает элементы НЕ удовлетворяющие условию)
        ___
        sorted() - сортирует поток в естественном порядке
        sorted(Comparator<T> comparator) - сортирует элементы с использованием компаратора.
        ___

        Stream<R> map(Function<T, R> action) - преобразует элементы потока с использованием заданной функции,
        в том числе в другой тип данных
         */

        /*
        Терминальные методы
        R collect(Collector<T, A, R> collector) - преобразует элементы потока в разные типы коллекции или другие структуры данных
         */

//        task1();
//        task2();
//        task3();
//        task4();
        task5();
    }

    private static void task5() {
        // получить список имен кошеу, чей вес больще 4
        List<Cat> cats = getListCats();
        List<String> catNames = cats.stream()
                .filter(cat -> cat.getWeight() > 4)
                .map(Cat::getName)
                .collect(Collectors.toList());

        System.out.println(catNames);
    }

    private static void task4() {
        List<Cat> cats = getListCats();
        // получить список всех имен
        //  получаем поток элементов другого типа
//        Stream<Cat> namesStream = cats.stream()
//                .map(cat -> cat.getName());
        List<String> catsNames = cats.stream()
                .map(Cat::getName)
                .collect(Collectors.toList());
        System.out.println(catsNames);
    }

    private static void task3() {
        List<Cat> cats = getListCats();
        Stream<Cat> catStream = cats.stream()
                .filter(cat -> cat.getName().length() > 4);
        //пока не запущен терминал метод промежуточные методы не выполняются
        List<Cat> longNameCats =catStream.collect(Collectors.toList());
        System.out.println("longNameCats " + longNameCats);
    }

    private static void task2() {
        List<Cat> cats = getListCats();

        //weight of cats more than 4 kg
        Stream<Cat> catStream = cats.stream()
                .filter(cat -> cat.getWeight() > 4);

        List<Cat> fatCats = catStream.collect(Collectors.toList());
        System.out.println(fatCats);
       // fatCats = catStream.filter(c -> c.getWeight() > 5).collect(Collectors.toList()); error, cannot reuse the closed stream again
    }

    private static List<Cat> getListCats(){
        return List.of(
                new Cat("Bear", 5, "brown"),
                new Cat("Python", 7, "green"),
                new Cat("Tiger", 3, "grey"),
                new Cat("Panda", 4, "black")
        );
    }
    private static void task1(){
        List<Integer> integers = List.of(-1, 12, 0, 5, 1, -15, 24, 0);

        //сптсок с положит числами, отсортированный в порядке возрастания

        List<Integer> result = new ArrayList<>();
        for (Integer integer : integers){
            if(integer > 0) result.add(integer);
        }
        result.sort(Comparator.naturalOrder());
        System.out.println(result);

        // у всех коллекций есть метод stream() создающий поток из элементов коллекции

        List<Integer> integersList = integers.stream()
                .filter(i -> i > 0)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("integersList: " + integersList);

        //Pipeline
        //integers.stream().filter(i-> i > 0).sorted().collect(Collectors.toList());
    }
}
