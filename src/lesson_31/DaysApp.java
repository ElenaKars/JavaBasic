package lesson_31;

public class DaysApp {
    public static void main(String[] args) {

        for (Day day : Day.values()) {
            System.out.println(day);
            System.out.println(day.getRussian());
            System.out.println(day.getDayOfWeek());
            System.out.println(day.testMethod());
            System.out.println("============\n");
        }
    }
}