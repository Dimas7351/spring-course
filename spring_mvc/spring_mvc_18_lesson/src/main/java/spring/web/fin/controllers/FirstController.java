package spring.web.fin.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name+ " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam("surname") String surname,
                              Model model){

        model.addAttribute("message","Goodbye, " + name+ " " + surname);
//        System.out.println("Hello, " + name+ " " + surname);
        return "first/goodbye";
    }

    @GetMapping("calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model){

        double answer;
        switch (action){
            case "multiplication":
                answer=a*b;
                break;
            case "addition":
                answer=a+b;
                break;
            case "subtraction":
                answer=a-b;
                break;
            case "division":
                answer= (double) a /b;
                break;
            default:
                answer=0;
                break;
        }

        model.addAttribute("answer", answer);

        return "first/calculator";

    }

}
