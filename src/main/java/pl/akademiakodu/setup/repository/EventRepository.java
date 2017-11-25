package pl.akademiakodu.setup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.setup.models.*;

import java.util.List;

/**
 * Created by Rafal Lewandowski on 03.11.2017.
 */

@Repository
public interface EventRepository extends JpaRepository<EventModel, Long> {

    List<EventModel> findByTitle (String title);
    List<EventModel> findByEventManager (User eventManager);
    List<EventModel> findAll();
}
