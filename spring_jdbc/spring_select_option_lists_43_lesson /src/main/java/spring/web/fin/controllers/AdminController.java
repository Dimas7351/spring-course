package spring.web.fin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.web.fin.dao.PersonDAO;
import spring.web.fin.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PersonDAO personDAO;

    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") Person person){
        model.addAttribute("people", personDAO.index());

        return "adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(Model model, @ModelAttribute("person") Person person){
        System.out.println(person.getId());
        model.addAttribute("person", personDAO.show(person.getId()));
        return "people/show";
    }
}
