package homework_38.task_1;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Sportsman[] sportsmens = new Sportsman[4];

        sportsmens[0] = new Sportsman("John", 23, 3);
        sportsmens[1] = new Sportsman("Julia", 23, 7);
        sportsmens[2] = new Sportsman("Stefany", 18, 5);
        sportsmens[3] = new Sportsman("Arnold", 30, 30);

        System.out.println("Сортировка с интерфейсом Comparable по именам");
        Arrays.sort(sportsmens);
        System.out.println(Arrays.toString(sportsmens));


        SportsmanComparator sportsmanComparator = new SportsmanComparator();

        Arrays.sort(sportsmens, sportsmanComparator);
        System.out.println("Сортировка в естественном порядке, определенного в Comparable по очкам");
        System.out.println(Arrays.toString(sportsmens));


        Arrays.sort(sportsmens, new Comparator<Sportsman>() {
            @Override
            public int compare(Sportsman o1, Sportsman o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("Сортировка с использованием анонимного класса Comparator для сортировки по age");
        System.out.println(Arrays.toString(sportsmens));

    }
}
