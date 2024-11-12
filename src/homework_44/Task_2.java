//Task 2
//Имеется список строк. Используя Stream API, найдите строку с минимальной длиной.
package homework_44;

import org.apiguardian.api.API;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Task_2 {
    public static void main(String[] args) {
        List<String> strings = List.of("Имеется", "", "список", "строк", "Используя", "Stream", "API", "найдите", "строку", "с", "минимальной", "длиной");
        System.out.println(getSmallestWord(strings));
    }

    private static String getSmallestWord(List<String> strings) {
        Optional<String> coll = strings.stream()
                .filter(str -> !str.isEmpty())
                .min(Comparator.comparingInt(String::length));
       return coll.orElse("Список пустой");
    };


}
