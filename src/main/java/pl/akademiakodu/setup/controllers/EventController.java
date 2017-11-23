    package pl.akademiakodu.setup.controllers;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.ModelMap;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import pl.akademiakodu.setup.models.*;
    import pl.akademiakodu.setup.models.forms.EventForm;
    import pl.akademiakodu.setup.service.*;

    import javax.validation.Valid;
    import java.util.List;

    /**
     * Created by Rafal Lewandowski on 05.11.2017.
     */
    @Controller
    public class EventController {


        @Autowired
        EventService eventService;

        @Autowired
        UserService userService;

        @GetMapping("/eventhost")
        public String eventhost (ModelMap modelMap){
            modelMap.addAttribute("eventForm", new EventForm());
            return "addingEventTemplate";
        }

        @PostMapping("/eventhost")
        public String eventHostPage(@ModelAttribute("eventForm") @Valid EventForm eventForm, BindingResult result, ModelMap modelMap){

            if(result.hasErrors()){
                return "addingEventTemplate";
            }

            List<EventModel> findByTitle = eventService.findByTitle(eventForm.getTitle());

            if (findByTitle.isEmpty()){
                modelMap.addAttribute("info", "Dodano pomyślnie nowe wydarzenie");
                List<User> users = userService.findByUsername("patriano");
                eventService.save(new EventModel(eventForm, users));
            } else {
                String error = "Title with this title already exist";
                modelMap.addAttribute("info", error);
            }
            return "addingEventTemplate";
        }

    }
