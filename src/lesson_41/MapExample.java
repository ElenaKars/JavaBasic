package lesson_41;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> okdTable = new Hashtable<>();//old version

        Map<Integer, String> map = new HashMap<>();

        //Value put(K key, V value)

        map.put(1, "Hello");//возвращает старое значение, кот соответсвует ключу ранее. Если не было ключа - вернет null
        String oldValue = map.put(1, "Hello");
                map.put(2, "World");
        map.put(3, "Java");
        map.put(4, "Python");
        oldValue = map.put(4, "Orange");
        System.out.println("map" + map);

        Map<Integer, String> newMap = new HashMap<>();
        newMap.put(0, "Python");
        newMap.put(2, "New Value");
        System.out.println("newMap: " + newMap);
        map.putAll(newMap);
        System.out.println(map);

        System.out.println(map.containsKey(10));
        System.out.println(map.containsValue("Apple"));
        String value = map.get(3);
        System.out.println(value);

        value = map.getOrDefault(3, "Default");
        System.out.println(value);
        value = map.getOrDefault(100, "Default");
        System.out.println(value);

        System.out.println("\n========Удаление пару ключ-значение по ключу========");
        System.out.println(map.remove(100));
        System.out.println(map.remove(4));
        System.out.println(map);
    }
}
