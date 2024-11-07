package lesson_40.set;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set = new HashSet<>(20); //коэфф-т загрузки 0,75
        set = new HashSet<>(List.of(1, 2, 3, 5, 6, 6, 5, 3));
        System.out.println(set);

        List <Integer> startValue = new ArrayList<>(List.of(15, 1, 2, 3, 8, 6, 15, 7, 0, 16, 32));
        Set<Integer> integers = new HashSet<>(startValue);
        System.out.println("integers hashSet: " + integers);
        Set<Integer> linkedSed = new LinkedHashSet<>(startValue);
        System.out.println("linkedSed: " + linkedSed);

        System.out.println("integers.add(100): " + integers.add(100));
        System.out.println(integers);
        System.out.println("integers.remove(100): " + integers.remove(100));
        System.out.println(integers);
        System.out.println("integers.contains(100): " + integers.contains(100));
        System.out.println("integers.contains(32): " + integers.contains(32));

        System.out.println("startValue: " + startValue);
        List<Integer> resultList = getUniqueList1(startValue);
        System.out.println("resultList: " + resultList);

        //SortedSet
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.addAll(startValue);
        System.out.println("sortedSet: " + sortedSet);

        sortedSet = new TreeSet<>(startValue);
        System.out.println(sortedSet);

        SortedSet<Integer> treeset = new TreeSet<>(Comparator.reverseOrder());
        treeset.addAll(startValue);
        System.out.println("treeset: " + treeset);

        treeset = new TreeSet<>((i1,i2) -> i2.compareTo(i1));
        treeset.addAll(startValue);
        treeset.add(10);
        System.out.println("treeset" + treeset);

        System.out.println("treeset.first(): " + treeset.first());
        System.out.println("treeset.last(): " + treeset.last());

        //возвращает часть множества, элементы которого строго меньше чем элемент
        SortedSet<Integer> integerSortedSet = new TreeSet<>(startValue);
        System.out.println(integerSortedSet);
        System.out.println("integerSortedSet.headSet(8): " + integerSortedSet.headSet(8));

        //возвращает часть множества, элементы которого строго больше чем элемент
        SortedSet<Integer> tailSet = integerSortedSet.tailSet(8);
        System.out.println("tailSet: " + tailSet);

        //subSet(E fromElement, E toElement) - возвращает новое множество, которое находится в диапозоне
        // от fromElement включительно до toElement невключительно

        System.out.println("integerSortedSet.subSet(3, 16): " + integerSortedSet.subSet(3, 16));

        //возвращает comparator, используемый для упорядочевания эл-в в этом множестве
        //вернет null если используется естественный порядок

        System.out.println("integerSortedSet.comparator(): " + integerSortedSet.comparator());
        Comparator<Integer> comparator = (Comparator<Integer>) treeset.comparator();
        System.out.println(comparator);
    }

    public static List<Integer> getUniqueList(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(Integer value : list) {
            if(!result.contains(value)){
                result.add(value);
            }
        }
        return result;
    }

    public static <T> List<T> getUniqueList1(List<T> list){
        Set<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

}
