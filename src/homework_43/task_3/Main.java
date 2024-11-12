//Task 3
//Дан список Person с полями name, age, city. Используйте Stream API для фильтрации людей,
// которые старше определенного возраста и проживают в определенном городе,
// а затем соберите их в список.
//
//Например, старше 25 лет и проживающих в городе "Berlin"
package homework_43.task_3;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 25, "Sidney");
        Person person1 = new Person("Ivan", 50, "Moscow");
        Person person2 = new Person("Chelsy", 75, "Sidney");
        Person person3 = new Person("Mercy", 33, "Nairobi");
        Person person4 = new Person("Johan", 18, "Berlin");
        Person person5 = new Person("Tom", 18, "Sidney");


        List<Person> persons = List.of(person, person1, person2, person3, person4);
        getPersonByAgeAndCity(persons);


    }

    private static void getPersonByAgeAndCity(List<Person> persons) {
        List<Person> newCollect = persons.stream()
                .filter(person -> person.getAge()>=21 && Objects.equals(person.getCity(), "Sidney"))
                .collect(Collectors.toList());
        System.out.println(newCollect);
    }
}
