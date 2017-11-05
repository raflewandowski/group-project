package pl.akademiakodu.setup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.setup.forms.EventForm;
import pl.akademiakodu.setup.repositories.EventRepository;
import javax.validation.Valid;

/**
 * Created by Rafal Lewandowski on 05.11.2017.
 */
@Controller
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/eventhost")
    public String eventHostPage(ModelMap modelMap){
        modelMap.addAttribute("eventForm", new EventForm());
        return "addEventTemplate";
    }

    @PostMapping("/eventhost")
    public String eventHostPage(@ModelAttribute("eventForm") @Valid EventForm eventForm, BindingResult result, ModelMap modelMap){

        if(result.hasErrors()){
            return "addEventTemplate";
        }

        modelMap.addAttribute("eventInformation", modelMap);
        return "addEventTemplate";
    }
}
