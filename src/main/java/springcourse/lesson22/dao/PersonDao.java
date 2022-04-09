package springcourse.lesson22.dao;

import org.springframework.stereotype.Component;
import springcourse.lesson22.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao
{
    private static int people_count = 0;
    private List<Person> people;

    //блок инициализации
    {
        people = new ArrayList<>();
        people.add(new Person(people_count++, "Саша"));
        people.add(new Person(people_count++, "Дима"));
        people.add(new Person(people_count++, "Алексей"));
        people.add(new Person(people_count++, "Федор"));
        people.add(new Person(people_count++, "Владимир"));
    }

    public List<Person> index()
    {
        return people;
    }

    public Person show(int id)
    {
        return people.get(id);
    }
}
