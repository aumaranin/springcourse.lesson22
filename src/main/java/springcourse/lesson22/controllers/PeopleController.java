package springcourse.lesson22.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springcourse.lesson22.dao.PersonDao;
import springcourse.lesson22.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController
{
    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao)
    {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model)
    {
        model.addAttribute("people", personDao.index());
        return "people/index" ;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person)
    {
        //model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person)
    {
        personDao.save(person);
        return "redirect:/people";
    }
}
