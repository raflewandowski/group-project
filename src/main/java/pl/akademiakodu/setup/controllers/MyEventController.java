package pl.akademiakodu.setup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyEventController {
    @GetMapping("/myEvent")
    public String myEvent (){
        return "myEventTemplate";

    }
}