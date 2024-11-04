package lesson_38;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car2.getSpeed() - car1.getSpeed();
    }
}
