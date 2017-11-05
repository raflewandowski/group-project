package pl.akademiakodu.setup.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Date;

/**
 * Created by Rafal Lewandowski on 03.11.2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventForm {

    private String eventTitle;
    private Date eventStartDate;
    private Date eventEndDate;
    private String eventCountry;
    private String eventAddress;
    private String eventCity;
    private String eventPostCode;
    private String eventDescription;
    private String eventCategory; //czy id?
//    @Min(0)
//    @Max(Integer.MAX_VALUE)
//    private int eventClickCount;
    @Min(value = 1)
    @Max(value = 100000)
    private int eventParticipantNumber;
    //Image
    @Min(value = 1)
    @Max(Integer.MAX_VALUE)
    private int eventPrice;
    //Eventhost id
    //Participant id
}



