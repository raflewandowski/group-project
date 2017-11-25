package pl.akademiakodu.setup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.setup.models.*;
import pl.akademiakodu.setup.repository.*;

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

    public void delete (EventModel eventModel){
        log.info("deleting event={}", eventModel);
        eventRepository.delete(eventModel);
        log.info("deleting event={}",eventModel);
    }

    public List<EventModel> findByEventManager (User eventManager) {
        log.info("finding event by eventManager={}",eventManager);
        return eventRepository.findByEventManager(eventManager);
    }

    public List<EventModel> findAll () {
        log.info("finding all events");
        return eventRepository.findAll();
    }
}
