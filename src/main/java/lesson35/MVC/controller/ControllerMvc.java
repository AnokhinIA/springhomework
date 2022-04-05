package lesson35.MVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerMvc {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
