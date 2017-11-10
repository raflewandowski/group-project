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
 * Created by Patryk Dudzik on 06.11.2017.
 */
@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(HttpServletRequest request, HttpSession session, ModelMap modelMap) {

        modelMap.addAttribute("user", new User());
        session = request.getSession();
        if (session.getAttribute("isLogged") != null) {
            return "redirect:/";
        }
        return "registerTemplate";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute User user, ModelMap modelMap) {

        List<User> findByNickname = userService.findByNickname(user.getNickname());
        List<User> findByEmail = userService.findByEmail(user.getEmail());

        if (findByNickname.isEmpty()) {
            if (findByEmail.isEmpty()) {
                modelMap.addAttribute("info", "Zarejestrowano pomyślnie, możesz się teraz zalogować " +
                        "podając login i hasło wpisane podczas rejestracji");
                modelMap.addAttribute("loginForm", new LoginForm());
                userService.save(user);
            } else {
                String error = "Email already in use";
                modelMap.addAttribute("info", error);
                return "registerTemplate";
            }
        } else {
            String error = "User with this nickname already exist";
            modelMap.addAttribute("info", error);
            return "registerTemplate";
        }
        return "loginTemplate";
    }
}
