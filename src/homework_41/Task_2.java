//Task2
//Опционально:
//Напишите метод, возвращающий частотный словарь вхождения символов в строку
//
//public class FrequencyDictionary {
//    public static void main(String[] args) {
//        String text = "Строка для проверки количества вхождений слов" +
//                ".\n Строка для проверки и теста. и количества слов для проверки";
//
//        Map<String, Integer> frequencyMap = frequencyDictionary(text);
//        frequencyMap.forEach((key, value) -> System.out.println(key + ": " + value));
//
//        Map<Character, Integer> frequencyCharsMap = frequencyCharsDictionary(text);
//
//        System.out.println("\nВхождение символов: ");
//        frequencyCharsMap.forEach((k, v) -> System.out.print("'" + k + "': " + v+ "; "));
//        System.out.println();
//    }
//Copy
////Output:
//Строка: 2
//для: 3
//проверки: 3
//количества: 2
//вхождений: 1
//слов: 2
//и: 2
//теста: 1
//
//Вхождение символов:
//'
//': 1; ' ': 15; '.': 2; 'С': 2; 'а': 5; 'в': 8; 'д': 4; 'е': 7; 'ж': 1; 'и': 8; 'й': 1; 'к': 7; 'л': 7; 'н': 1; 'о': 10; 'п': 3; 'р': 8; 'с': 5; 'т': 6; 'х': 1; 'ч': 2; 'я': 3;
package homework_41;

import java.util.HashMap;
import java.util.Map;

public class Task_2 {
    public static void main(String[] args) {
        String text = "Строка для проверки количества вхождений слов" +
                ".\n Строка для проверки и теста. и количества слов для проверки";

        Map<String, Integer> frequencyMap = frequencyDictionary(text);
        Map<String, Integer> frequencyMap1 = frequencyDictionary1(text);
        frequencyMap.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("\n==========\n");
        frequencyMap1.forEach((key, value) -> System.out.println(key + ": " + value));

        Map<Character, Integer> frequencyCharsMap = frequencyCharsDictionary(text);

        System.out.println("\nВхождение символов: ");
        frequencyCharsMap.forEach((k, v) -> System.out.print("'" + k + "': " + v+ "; "));
        System.out.println();
    }

    private static Map<Character, Integer> frequencyCharsDictionary(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
//        Character[] symbols = new Character[chars.length];
        for (char symbol : chars){
                map.put(symbol,map.getOrDefault(symbol,0)+1);
        }
        return map;
    }

    private static Map<String, Integer> frequencyDictionary1(String text) {
        String[] words = text.trim().replaceAll("[^a-zA-Z0-9а-яА-Я ]", "").split("\\s+");
        Map<String, Integer> result = new HashMap<>();
        for(String word : words) {
            result.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
        }
return result;

    };

    private static Map<String, Integer> frequencyDictionary(String text) {
        String newStr = text.trim().replaceAll("[^a-zA-Z0-9а-яА-Я ]", "");
        String[] words = newStr.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) +1);
        }
        return map;
    }
}
