package pl.akademiakodu.setup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FriendsController {
    @GetMapping("/friends")
    public String friends (){
        return "friendsTemplate";

    }
}