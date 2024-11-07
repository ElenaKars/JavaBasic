package lesson_40.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ListExample {
    public static void main(String[] args) {
        //конструкторы ArrayList
        List<Integer> list = new ArrayList<>();
        list = new ArrayList<>(50); //создает пустой список с указанной емкостью
        list = new ArrayList<>(List.of(1, -10, 5, 0, 25, 100));// принимает коллекцию
        // создает список, содержащий все элементы указанной коллекции

        // Конструкторы LinkedList
        list = new LinkedList<>();
        list = new LinkedList<>(List.of(1, -10, 5, 0, 25, 100));

        //Методы интерфейса List

        list.add(1000);// добавляет в конец списка
        list.add(-100);// добавляет в конец списка
        System.out.println("list: " + list);

        //void add(int ind, E el) добавляет на указанную позицию

        list.add(2,105);
        System.out.println("list: " + list);

        //E get (int ind) возвращает эл по инд
        int value = list.get(5);
        System.out.println("int value = list.get(5): " + value);

        //E remove - удаляет элемент по инд, возвращает старое значение
        System.out.println(list.remove(5));
        System.out.println(list);

        //удадение по значению (из интерфейса Collection) принимает Obj (ссылочный тип)
        list.remove(Integer.valueOf(1000));
        System.out.println(list);

        //поиск элементов по значению. Возвращает индекс
        //int indexOf(Object o)
        //int lastIndexOf(Object o)

        System.out.println("list.indexOf(-100): " + list.indexOf(-100));
        System.out.println("list.lastIndexOf(-100): " + list.lastIndexOf(-100));

        // void sort(Comparator<? super E> comparator - сортирует список с использованием указанного компаратора
        list.sort((i1, i2) -> i2.compareTo(i1));
        System.out.println(list);

        //List<E> sublist(int indexFrom, int indexTo) - возвращает список элементов в заданных пределах
        List<Integer> sublist = list.subList(1,5);
        System.out.println("sublist: " + sublist);
    }
}
