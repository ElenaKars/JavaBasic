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
        String newStr = str.trim().replaceAll("[^a-zA-Z0-9а-яА-Я ]", "");
        String[] wordsArr = newStr.split("\\s+");
        Set<String> set = new TreeSet<>(Comparator.comparing(String :: length).thenComparing(Comparator.naturalOrder()));
        set.addAll(Arrays.asList(wordsArr));

        return new ArrayList<>(set);

    }
}
