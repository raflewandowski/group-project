package pl.akademiakodu.setup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.setup.models.User;
import pl.akademiakodu.setup.models.forms.LoginForm;
import pl.akademiakodu.setup.service.UserService;

import javax.servlet.http.*;
import java.util.List;

/**
 * Created by Patryk Dudzik on 03.11.2017.
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

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
        String nickname = loginForm.getNickname();
        List<User> userList = userService.findByNickname(nickname);
        if (!userList.isEmpty()) {
            if (loginForm.getPassword().equals(userList.get(0).getPassword())) {
                session.setAttribute("username", loginForm.getNickname());
                session.setAttribute("isLogged", true);
                return "redirect:/";
            }
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
