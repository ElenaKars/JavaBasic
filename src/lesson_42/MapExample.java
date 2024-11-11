package lesson_42;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> mapColors  = new HashMap<>();
        mapColors.put(1, "red");
        mapColors.put(16, "green");
        mapColors.put(5, "blue");

        System.out.println("mapColors: " + mapColors);

        System.out.println("mapColors.containsValue(\"blue\"): " + mapColors.containsValue("blue"));
        System.out.println("mapColors.containsKey(32): " + mapColors.containsKey(32));

        String deleteValue = mapColors.remove(100);
        System.out.println("mapColors.remove(100): " + deleteValue);
        deleteValue = mapColors.remove(5);
        System.out.println("mapColors.remove(5): " + deleteValue);
        System.out.println(mapColors);
//        mapColors.clear();

        System.out.println("mapColors.isEmpty(): " + mapColors.isEmpty());
        mapColors.put(7, "yellow");
        mapColors.put(8, "white");
        mapColors.put(24, "white");
        System.out.println(mapColors);
        System.out.println("\n==========\n");

        Collection<String> values = mapColors.values();
        System.out.println("values.size(): " + values.size());
        System.out.println("values: " + values);

        //Set<K> keySet

        Set<Integer> keys = mapColors.keySet();
        System.out.println("keySet: " + keys);

        for(Integer key : keys){
            System.out.print(key + ": " + mapColors.get(key) + "; ");
        }
        System.out.println();

        keys.remove(7);
        System.out.println(keys);
        System.out.println("mapColors: " + mapColors);

        values.remove("red");
        System.out.println(values);
        System.out.println(mapColors);

        //Map.Entry <K, V> - представляет собой пары ключ - значения
        //Set<Map.Entry<>K,V> entrySet - возвращакт Set вхождений всех пары ключ -значение

        Set<Map.Entry<Integer, String>> entrySet = mapColors.entrySet();
        System.out.println("entrySet: " + entrySet);
        for(Map.Entry<Integer, String> entry : mapColors.entrySet()) {
            System.out.print("entry.getKey(): " + entry.getKey());
            System.out.print(" --> ");
            System.out.println("entry.getValue(): " + entry.getValue());
            if(entry.getKey().equals(8)){
                entry.setValue("JAVA!");
            }
        }
        System.out.println("\n========\n");
        System.out.println(mapColors);

        mapColors.forEach((key, value) -> System.out.println("key: " + key + "value: " + value));

        System.out.println("\n========\n");
        mapColors.forEach((k, v) -> {
            System.out.println("Iteration:");
            System.out.println("key: " + k + "; " + "value: " + v);
            System.out.println("\n========\n");
        });
    }
}
