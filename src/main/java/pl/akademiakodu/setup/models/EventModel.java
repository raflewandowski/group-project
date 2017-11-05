package pl.akademiakodu.setup.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by Rafal Lewandowski on 03.11.2017.
 */

@Data
@Entity
@Table (name = "event")
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;
    private String eventTitle;
    private Date eventStartDate;
    private Date eventEndDate;
    private String eventCountry;
    private String eventAddress;
    private String eventCity;
    private String eventPostCode; //nie int?
    private String eventDescription;
    private String eventCategory; //czy id?
    //private int eventClickCount;
    private int eventParticipantNumber;
    //Image
    private int eventPrice;
    private LocalDateTime eventCreationTimeLog;
    //Eventhost id
    //Participant id
}
