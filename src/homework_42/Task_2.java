//Task 2
//Подсчет слов по длине
//Напишите программу, которая подсчитывает количество слов определенной длины в заданном тексте (строке).
//
//Инструкции:
//Используйте HashMap<Integer, Integer>, где ключом является длина слова, а значением — количество слов этой длины.
//Прочитайте текст и обновите карту соответствующим образом.
//Выведите результаты подсчета.
package homework_42;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Task_2 {
    public static void main(String[] args) {
        String text = "Используйте HashMap<Integer, Integer>, где ключом является длина слова, а значением — количество слов этой длины.";
        Map<Integer, Integer> wordLengths = countWordLength(text);

        for(Map.Entry<Integer, Integer> entry : wordLengths.entrySet()) {
            System.out.println("Длина слова: " + entry.getKey() + ", количество слов: " + entry.getValue());
        }
    }

    public static Map<Integer, Integer> countWordLength(String text) {
        Map<Integer, Integer> map = new HashMap<>();

        // Очистка текста от лишних символов, сохраняя пробелы
        text = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "").toLowerCase();
        String[] words = text.split("\\s+");

        // Подсчет слов по длине
        for(String word : words) {
            if(!word.isEmpty()) {
                int length = word.length();
                map.merge(length, 1, Integer::sum); // Увеличение счётчика для длины слова
            }
        }
        return map;
    }
}
