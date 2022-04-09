package springcourse.lesson22.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController
{
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String first_name,
                            @RequestParam(value = "lname", required = false) String last_name, Model model)
    {
        String mes = "Привет " + first_name + " " + last_name;
        model.addAttribute("message", mes);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatorPage(HttpServletRequest request,
                            Model model)
    {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String action = request.getParameter("action");
        System.out.println(a);
        System.out.println(b);
        System.out.println(action);
        //model.addAttribute("message", message);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage()
    {
        return "first/goodbye";
    }
}