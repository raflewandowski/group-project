package pl.akademiakodu.setup.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.setup.models.EventModel;
import pl.akademiakodu.setup.repositories.EventRepository;

import java.util.List;

/**
 * Created by Rafal Lewandowski on 12.11.2017.
 */
@Service
public class EventService {

    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    @Autowired
    EventRepository eventRepository;

    public List<EventModel> findByTitle (String title) {
        log.info("finding event by title=()",title);
        return eventRepository.findByTitle(title);
    }

    public void save (EventModel eventModel){
        log.info("adding event={}", eventModel);
        eventRepository.save(eventModel);
        log.info("added event={}",eventModel);
    }
}
