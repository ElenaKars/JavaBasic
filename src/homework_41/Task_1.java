//Task 1
//Частотный словарь слов: Напишите метод, который принимает строку текста
// и возвращает Map<String, Integer>, где каждому слову соответствует количество его вхождений в текст.
package homework_41;

import java.util.*;

public class Task_1 {
    public static void main(String[] args) {
        String text1 = "apple banana apple orange banana apple";
        Map<String, Integer> words = getNumOfRepeatingWords(text1);
        System.out.println(words);
    }

    public static Map<String, Integer> getNumOfRepeatingWords(String str){
        String newStr = str.trim().replaceAll("[^a-zA-Z0-9а-яА-Я ]", "");
        String[] words = newStr.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
            }

           return map;
    }
}
