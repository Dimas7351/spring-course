package spring.web.fin.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.web.fin.dao.PersonDAO;
import spring.web.fin.models.Person;
import spring.web.fin.services.ItemsService;
import spring.web.fin.services.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final ItemsService itemsService;

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PeopleService peopleService, ItemsService itemsService, PersonDAO personDAO) {
        this.peopleService = peopleService;
        this.itemsService = itemsService;
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model){
//        model.addAttribute("people", peopleService.findAll());
//
//        itemsService.findByItemName("Airpods");
//        itemsService.findByOwner(peopleService.findAll().get(0));
//
//        peopleService.test();

        personDAO.testNPlus1();

        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){ // (@ModelAttribute("person") Person person)
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping() // будем попадать сюда через /people
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "people/new";

        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id){
        if(bindingResult.hasErrors())
            return "people/edit";

        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        peopleService.delete(id);
        return "redirect:/people";
    }
}
