package lesson_38;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorApp {
    public static void main(String[] args) {
        int[] numbers = {9, 5, 1, 2, 3, 0, 4};

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] strings = {"Abby", "Cindy", "apple", "Zebra"};
        Arrays.sort(strings);

        System.out.println(Arrays.toString(strings));

        Car[] cars = new Car[5];

        cars[0] = new Car("Alfa", 2021, 120);
        cars[1] = new Car("BMW", 2020, 190);
        cars[2] = new Car("Citroen", 2018, 190);
        cars[3] = new Car("VW", 2021, 250);
        cars[4] = new Car("Ferrari", 2024, 300);

        System.out.println(Arrays.toString(cars));
        Arrays.sort(cars);
        System.out.println(Arrays.toString(cars));
        System.out.println("\n===============\n");
        CarSpeedComparator carSpeedComparator = new CarSpeedComparator();

        Arrays.sort(cars, carSpeedComparator);
        System.out.println(Arrays.toString(cars));

        System.out.println("\n===============\n");

        CarModelComparator carModelComparator = new CarModelComparator();

        Arrays.sort(cars, carModelComparator);

        System.out.println(Arrays.toString(cars));
        System.out.println("\n===============Anonymous class\n");

        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return  car1.getModel().compareTo(car2.getModel());
            }
        });

        System.out.println(Arrays.toString(cars));

        //сравнение по году выпуску в порядке возрастания,
        // если совпадает год выпуска, сравнить модели в порядке убывания

        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                int yearCompare = car1.getYear() - car2.getYear();
                if(yearCompare == 0){
                    return car2.getModel().compareTo(car1.getModel());
                }
                 return yearCompare;
            }
        });
        System.out.println(Arrays.toString(cars));

        //Функциональный интерфейс - интерфейс, который имеет ровно один абстрактный метод
        //Лямбда-выражения - способ краткой записи анонимныч функций.
        // Используется исключительно для реализации функциональных интерфейсов
        // (параметр) -> {тело выражения}

        Arrays.sort(cars, (car1, car2) -> car1.getSpeed() - car2.getSpeed());

        Arrays.sort(cars, (c1, c2) -> {
            int yearCompare = c1.getYear() - c2.getYear();
            if(yearCompare == 0){
                return c2.getModel().compareTo(c1.getModel());
            }
            return yearCompare;
        });
        System.out.println(Arrays.toString(cars));


//        Comparator<Car> comparator = (c1, c2) -> {
//            int yearCompare = c1.getYear() - c2.getYear();
//            if(yearCompare == 0){
//                return c1.getSpeed() - c2.getSpeed();
//            }
//            return yearCompare;
//        };

        Comparator<Car> comparator = (c1, c2) -> {
            int yearCompare = Integer.compare(c1.getYear(), c2.getYear());

            if (yearCompare == 0) {
                return Integer.compare(c1.getSpeed(), c2.getSpeed());
            }
            return yearCompare;
        };

        Arrays.sort(cars, comparator);
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, (c1, c2) -> c2.getYear() - c1.getYear());
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, Comparator.comparing(Car::getYear).reversed());
        System.out.println(Arrays.toString(cars));
        Arrays.sort(cars, Comparator.comparing(Car::getYear).thenComparing(Car::getModel));

    }
}
