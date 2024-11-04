package homework_38.task_1;

import java.util.Comparator;

public class SportsmanComparator implements Comparator<Sportsman> {
    @Override
    public int compare(Sportsman o1, Sportsman o2) {
        return o1.getScore() - o2.getScore();
        //return Integer.compare(o1.getScore(), o2.getScore()); более надежный вариант, в случае переполнения
    }
}
