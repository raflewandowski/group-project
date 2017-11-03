package pl.akademiakodu.setup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.setup.models.SessionInfo;
import pl.akademiakodu.setup.models.forms.LoginForm;

import javax.servlet.http.*;
import java.util.Arrays;

/**
 * Created by Patryk Dudzik on 03.11.2017.
 */

@Controller
public class LoginController {

    @Autowired
    SessionInfo sessionInfo;

    @GetMapping ("/login")
    public String login (ModelMap modelMap) {

        if (sessionInfo.isLogged()) {
            return "redirect:/";
        }
        modelMap.addAttribute("loginForm", new LoginForm());
        return "loginTemplate";
    }

    @PostMapping ("/login")
    public String loginForm (@ModelAttribute LoginForm loginForm, ModelMap modelMap, HttpServletResponse response) {

        if (loginForm.getNickname().equals("Patriano") & loginForm.getPassword().equals("1234")) {
            Cookie newCookie = new Cookie("logingInfo", "Patriano");
            response.addCookie(newCookie);
            return "redirect:/";
        }
        String error= "Bad password or nickname";
        modelMap.addAttribute("info", error);

        return "loginTemplate";
    }

    @GetMapping ("/logout")
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies).forEach(cookie -> {
                if (cookie.getName().equals("logingInfo")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    sessionInfo.setLogged(false);
                    sessionInfo.setUsername(null);

                }
            });
        }
        return "redirect:/";
    }
}
