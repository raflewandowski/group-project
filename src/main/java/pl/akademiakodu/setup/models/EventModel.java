package pl.akademiakodu.setup.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.akademiakodu.setup.forms.EventForm;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Rafal Lewandowski on 03.11.2017.
 */

@Data
@Entity
@NoArgsConstructor
@Table (name = "event")
public class EventModel {

    @Id
    @GeneratedValue
    private Long id ;
    private String title;
    @Column (name = "startdate")
    private LocalDate startDate;
    @Column (name = "enddate")
    private LocalDate endDate;
    @Column (name = "starttime")
    private LocalTime startTime;
    @Column (name = "endtime")
    private LocalTime endTime;
    private String country;
    private String location;
    private String city;
    @Column (name = "postcode")
    private String postCode;
    private String description;
    private int category; //int czy String?
    //private int eventClickCount;
    @Column (name = "participantnumber")
    private int participantNumber;
    //Image
    private int price;
    @Column (name = "timelog")
    private LocalDateTime timeLog;
    //Eventhost id
    //Participant id

    public EventModel(EventForm form) {
        title = form.getTitle();
        startDate = form.getFormatedStartDate();
        endDate = form.getFormatedEndDate();
        startTime = form.getFormatedStartTime();
        endTime = form.getFormatedEndTime();
        country = form.getCountry();
        location = form.getLocation();
        city = form.getCity();
        postCode = form.getPostCode();
        description = form.getDescription();
        category = form.getCategory();
        participantNumber = form.getParticipantNumber();
        price = form.getPrice();
        timeLog = LocalDateTime.now();
    }
}
