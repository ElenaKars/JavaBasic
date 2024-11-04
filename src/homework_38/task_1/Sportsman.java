//Task 1
//Создайте класс Sportsman с тремя полями: name (имя), age (возраст) и score (рейтинг).
//
//Реализуйте интерфейс Comparable в классе Sportsman, чтобы задать “естественный” порядок сортировки, например, по name.
//
//Создайте отдельный класс, реализующий Comparator, чтобы сортировать объекты класса Sportsman по другому критерию, например, по score.
//
//В методе main создайте массив из нескольких объектов Sportsman.
//
//Отсортируйте его с использованием:
//
//естественного порядка, определенного в Comparable,
//данного класса Comparator,
//анонимного класса Comparator для сортировки по третьему полю (например, age).
//Выведите каждый вариант отсортированного массива в консоль.
package homework_38.task_1;

public class Sportsman implements Comparable<Sportsman> {
    private String name;
    private int age;
    private int score;

    public Sportsman(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Sportsman sportsman1) {
        return this.name.compareTo(sportsman1.name);
    }
}
