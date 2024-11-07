//Напишите метод, принимающий строку и возвращающий Список ее слов без повторений, отсортированный в порядке увеличения длин слов.
//
//Если строки имеют одинаковую длину - сортировать в естественном порядке
//
//public static void main(String[] args) {
//        String testString = "Тестовая строка для удаления слов, которые повторяются. \"строка\" для удаления!";
//        System.out.println(StringUtil.getUniqueSortedWords(testString));
//    }
//Copy
//// Output:
//[для, слов, строка, которые, Тестовая, удаления, повторяются]
package homework_40;

import java.util.*;

public class Task_1 {
    public static void main(String[] args) {
        String testString = "Тестовая строка для удаления слов, которые повторяются. \"строка\" для удаления!";
        System.out.println(getUniqueSortedWords(testString));

    }
    public static List<String> getUniqueSortedWords (String str){
        String newStr = str.replaceAll("[^a-zA-Z0-9а-яА-Я ]", "");
        String[] wordsArr = newStr.split(" ");
        Set<String> set = new TreeSet<>(Arrays.asList(wordsArr));

        List<String> res = new ArrayList<>(set);
        res.sort(Comparator.comparing(String :: length).thenComparing(String::compareTo));

        return res;

    }
}
