package pl.akademiakodu.setup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CreateEventController {
    @GetMapping("/create")
    public String createEvent (HttpServletRequest request, HttpSession session, ModelMap modelMap){
        return "createEventTemplate";
    }
}
