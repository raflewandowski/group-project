package pl.akademiakodu.setup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.setup.models.EventModel;

import java.util.List;

/**
 * Created by Rafal Lewandowski on 03.11.2017.
 */

@Repository
public interface EventRepository extends CrudRepository<EventModel, Long> {

    List<EventModel> findByTitle (String title);

}
