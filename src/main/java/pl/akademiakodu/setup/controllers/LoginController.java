package pl.akademiakodu.setup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.setup.models.forms.LoginForm;

import javax.servlet.http.*;

/**
 * Created by Patryk Dudzik on 03.11.2017.
 */

@Controller
public class LoginController {

    @GetMapping ("/login")
    public String login (HttpServletRequest request, HttpSession session, ModelMap modelMap) {

        session = request.getSession();

        if (session.getAttribute("isLogged") != null) {
            return "redirect:/";
        }
        modelMap.addAttribute("loginForm", new LoginForm());
        return "loginTemplate";
    }

    @PostMapping ("/login")
    public String loginForm (@ModelAttribute LoginForm loginForm, ModelMap modelMap,
                             HttpServletRequest request, HttpSession session) {

        session = request.getSession();
        if (loginForm.getNickname().equals("Patriano") & loginForm.getPassword().equals("1234")) {
            session.setAttribute("username", "Patriano");
            session.setAttribute("isLogged", true);
            return "redirect:/";
        }
        String error = "Bad password or nickname";
        modelMap.addAttribute("info", error);
        return "loginTemplate";
    }

    @GetMapping ("/logout")
    public String logout (HttpServletRequest request, HttpSession session) {

        session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
