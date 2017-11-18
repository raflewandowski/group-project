package pl.akademiakodu.setup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.setup.repository.UserRepository;

import javax.servlet.http.*;

/**
 * Created by Patryk Dudzik on 02.11.2017.
         */

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping ("/")
    public String mainPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {

        session = request.getSession();
        if (session.getAttribute("isLogged") != null) {
            modelMap.addAttribute("isLogged", true);
            modelMap.addAttribute("username", session.getAttribute("username"));
        } else {
            modelMap.addAttribute("isLogged", false);
        }
        return "indexTemplate";
    }

    @GetMapping("/all")
    public String allUsers(ModelMap modelMap){
        modelMap.addAttribute("users", userRepository.findAll());
        return "indexTemplate";
    }
}
