//Task 3
//Опционально
//Написать метод, возвращающий первый неповторяющийся символ в строке
//
//public static void main(String[] args) {
//        String string = "abcdefj ab,cdf,";
//        System.out.println(StrUtil.getFirstUniqueChar(string));
//    }
//    
//    //Output:
//    e

package homework_40;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Task_3 {
    public static void main(String[] args) {
        String string = "abcdefj ab,cdf,";
        System.out.println(getFirstUniqueChar(string));
    }

    private static Character getFirstUniqueChar(String string) {
        if(string == null || string.isEmpty()) return 0;
        int[] chars = new int[138];
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            chars[c]++;
        }
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (chars[c] == 1){
                return c;
            }
        }
        return null;
    }
}
