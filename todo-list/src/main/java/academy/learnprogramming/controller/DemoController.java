package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;


    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == request methods ==
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(
            Model model,
            @RequestParam String user,
            @RequestParam int age) {
        //model.addAttribute("user", "Tim");
        //log.info("model = {}", model);
        //return "welcome";

        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        return "welcome";
    }


    // == model attribute ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        return demoService.getWelcomeMessage();
    }

}
