package pl.akademiakodu.setup.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.setup.models.EventModel;

/**
 * Created by Rafal Lewandowski on 03.11.2017.
 */

public interface EventRepository extends CrudRepository<EventModel, Integer> {

}
