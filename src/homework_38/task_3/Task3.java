package homework_38.task_3;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        Integer[] integers = { 1, 6, 5, 4, 7, 8, 9, 2, 7, 3 };

        Arrays.sort(integers, (int1, int2) ->
                int1 % 2 == 0 && int2 % 2 !=0 ? -1 :
                        int1 % 2 != 0 && int2 % 2 ==0 ? 1 :
                int1 % 2 == 0 && int2 % 2 == 0 ? Integer.compare(int1, int2) :
                        int1 % 2 != 0 &&  int2 % 2 != 0 ? Integer.compare(int2, int1) :
                                0
                );

        System.out.println(Arrays.toString(integers));
    }
}
