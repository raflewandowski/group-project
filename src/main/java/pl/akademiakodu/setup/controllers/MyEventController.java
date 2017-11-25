package pl.akademiakodu.setup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.setup.models.*;
import pl.akademiakodu.setup.service.*;

import java.security.Principal;
import java.util.List;

@Controller
public class MyEventController {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @GetMapping("/myEvent")
    public String myEvent (ModelMap modelMap, Principal principal){

        User user = userService.findByUsername(principal.getName()).get(0);
        List<EventModel> events = eventService.findByEventManager(user);
        modelMap.addAttribute("events", events);
        return "myEventTemplate";
    }
}