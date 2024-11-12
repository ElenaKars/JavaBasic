package lesson_44;

import lesson_43.Cat;

import java.util.*;
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

        distinct() - удаляет дубликаты из потока. Сравниваем (определяет равенство) методом equals()

        void peek(Consumer<T> action) - выполняет действие для каждого элемента потока

        limit(long maxSize) - ограничивает кол-во элементов потока заданным значением. В потоке может быть не больше maxSize
        skip(long n) - пропускает первые n элементов потока

        mapToObj(IntFunction() mapper) - преобразование примитивного типа данных в ссылочный тип при помощи заданной функции

        mapToInt - преобразует поток Stream<Integer> в IntStream (поток примитивов)

        boxed() - используется для преобразования потока примитивов (IntStream, DoubleStream)
        в поток их соответсвующий оберток (Stream<Integer>, Stream<Double)

         */

        /*
        Терминальные методы
        R collect(Collector<T, A, R> collector) - преобразует элементы потока в разные типы коллекции или другие структуры данных

        void forEach(Consumer<T? action) - выполняет заданное действия для каждого элемента потока

        Optional<T> min(Comparator<T> comparator) - элемент с минимальным значением в соответствии с компаратором
        Optional<T> max(Comparator<T> comparator) - элемент с максимальным значением в соответствии с компаратором
         */

//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
 //       task9();
  //      task10();
//        task11();
   //     task12();
        task13();
    }

    private static void task13() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6};

        List<Integer> integers = Arrays.stream(ints)
                .boxed()
//                .mapToObj(i -> i)
//                .mapToObj(i-> Integer.valueOf(i))
                .collect(Collectors.toList());
        System.out.println(integers);

        int[] ints1 = integers.stream()
                .mapToInt(i ->i)
                .toArray();
        System.out.println(Arrays.toString(ints1));
    }

    private static void task12() {
        List<Integer> integers = List.of(0, 5, 1, 4, 7, 55, 78);

        // получить список из 3 самых маленьких чисел из списка
        List<Integer> smallestNums = integers.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(smallestNums);
        //получить список чисел, отбросив 2 самых маленьких
        List<Integer> arr = integers.stream()
                .sorted()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(arr);

        Integer[] arrIntegers = integers.stream()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(arrIntegers));
    }

    private static void task11() {
        List<Cat> cats = getListCats();
        Optional<String> longCatsName = cats.stream()
                .filter(Objects::nonNull)
                .map(Cat::getName)
                .filter(Objects::nonNull)
                .max(Comparator.comparing(String::length));

        if(longCatsName.isPresent()){
            System.out.println(longCatsName.get());
        } else {
            System.out.println("Cats were not found");
        }

        String longestNullString = cats.stream()
                .map(Cat::getName)
                .max(Comparator.comparing(String::length))
                .orElse(null);
        System.out.println("longestNullString: " + longestNullString);

    }

    private static void task10() {
        //min, max, Optional
       // Optional<T> класс - обертка, который может содержать или объект типа Т или null
        // Optional <User> может содержать или User, или null

        List<Integer> integers = List.of(5, 4, 14, 59, 32, 24, -1, -5);

        //хочу максимальное отр число
        Optional<Integer> max = integers.stream()
                .filter(i -> i < 0)
                .peek(System.out::println)
                .max(Comparator.naturalOrder());

        System.out.println("max.isPresent(): " + max.isPresent());//вернет true, если значение присутствует, не null
        System.out.println("max.isEmpty(): " + max.isEmpty());

        if(max.isPresent()) {
            Integer value = max.get();// если null - вернет ошибку NoSuchElementException
            System.out.println(value);
        } else {
            System.out.println("error here is null");
        }
        //возвращвет значение, если оно присутствует. Если null - вернет defaultValue
        Integer optionalValue = max.orElse(-100);
        System.out.println("optionalValue: " + optionalValue);

        Optional.empty();//возвращает пустой Optional (завернут null)
        Optional.of(new Object()); //возвращает Optional с не null значением (если завернуть null - ошибка)
        Optional.ofNullable(null);//возвращает Optional. Можно завергуть или значение, или null
    }

    private static Optional<Cat> findCat2(String name){
        List<Cat> cats = getListCats();

        Cat res = null;
        for(Cat cat : cats){
            if(cat.getName().equals(name)){
                res = cat;
            }
        }
        return Optional.ofNullable(res);
    }
    private static Optional<Cat> findCat(String name){
        List<Cat> cats = getListCats();

        for(Cat cat : cats){
            if(cat.getName().equals(name)){
                return Optional.of(cat);
            }
        }
        return Optional.empty();
    }
    private static void task9() {
        // создание стрима map
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 5);
        map.put("Cherry", 0);

        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void task8() {
        Cat cat = new Cat("Bear", 5, "brown");
        Cat cat1 = new Cat("Python", 7, "green");
        Cat cat2 = new Cat("Tiger", 3, "grey");
        Cat cat3 = new Cat("Panda", 4, "black");
        Cat[] cats = new Cat[]{cat, cat1, null, new Cat(null, 10, "red")};


        // получить список кошек, вес которых больше 4
        // получить поток из элементов массива
        List<Cat> bigCats = Arrays.stream(cats)
//                .filter(c -> c!= null)//оставить только не null
//                .filter(c-> Objects.nonNull(c))//оставить только не null
                .filter(Objects::nonNull)//оставить только не null
                .filter(c -> Objects.nonNull(c.getName()))//проверка какого-то поля на null
                .filter(c -> c.getWeight() > 4)
                .collect(Collectors.toList());
        System.out.println(bigCats);
    }

    private static void task7() {
        //изменить имя котов, вес которых меньше 5 вывести в консоль все элементы потока
        List<Cat> cats = getListCats();
        Stream<Cat> catStream = cats.stream()
                .filter(cat -> cat.getWeight() < 5)
                .peek(cat -> cat.setName("Slim " + cat.getName()));//промежуточный метод, выполняет действие для каждого элемента

        catStream.forEach(cat -> System.out.println(cat));//терминальный метод, выполняет действие для каждого элемента
//        System.out.println(cats);
    }

    private static void task6() {
      //  получить список имен кошек, у которых имена короче 5 символов
        List<Cat> cats = getListCats();
        List<String> catNames = cats.stream()
                .filter(cat -> cat.getName().length() < 5)
                .map(cat -> cat.getName())
                .collect(Collectors.toList());
        System.out.println(catNames);

        List<String> catNames2 = cats.stream()
                .map(Cat::getName)
                .filter(name -> name.length() < 5)
                .collect(Collectors.toList());
        System.out.println(catNames2);
    }

    private static void task5() {
        // получить список имен кошек, чей вес больще 4
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
