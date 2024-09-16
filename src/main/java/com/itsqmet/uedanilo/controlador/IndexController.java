package com.itsqmet.uedanilo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping("/home")
    public String pageHome() {
        return "index";
    }
    
}
