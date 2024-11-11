//Напишите программу, которая проверяет,
// являются ли две заданные строки анаграммами (то есть содержат ли они одинаковые буквы в разном порядке).
package homework_42;

import java.util.HashMap;
import java.util.Map;

public class Task_1 {
    public static void main(String[] args) {
        String str1 = "Listen";
        String str2 = "Silent";
        if(areAnagrams(str1, str2)){
            System.out.println("Strings are anagrams");
        } else {
            System.out.println("Strings are anagrams");
        }

    }
    public static boolean areAnagrams(String str1, String str2){
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        if(str1.length() != str2.length()) return false;

        Map<Character, Integer> charCountMap1 = getCharFrequencyMap(str1);
        Map<Character, Integer> charCountMap2 = getCharFrequencyMap(str2);

        return charCountMap1.equals(charCountMap2);

    }

    private static Map<Character, Integer> getCharFrequencyMap(String str1) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : str1.toCharArray()){
            Integer amount = map.getOrDefault(ch, 0);
            map.put(ch, amount + 1);
        }
        return map;

    }


}
