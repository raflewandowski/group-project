package pl.akademiakodu.setup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.setup.models.SessionInfo;

import javax.servlet.http.*;
import java.util.Arrays;

/**
 * Created by Patryk Dudzik on 02.11.2017.
         */

@Controller
public class MainController {

    @Autowired
    SessionInfo sessionInfo;

    @GetMapping ("/")
    public String mainPage(HttpServletRequest request, ModelMap modelMap) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies).forEach(cookie -> {
                if (cookie.getName().equals("logingInfo")){
                    sessionInfo.setLogged(true);
                    sessionInfo.setUsername(cookie.getValue());
                }
            });
        }
        return "indexTemplate";
    }
}
