package pl.akademiakodu.setup.models;

import lombok.*;
import pl.akademiakodu.setup.models.forms.EventForm;

import javax.persistence.*;
import java.time.*;
import java.util.*;

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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "event_eventmanager", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns =
    @JoinColumn (name = "user_id"))
    private List<User> eventManager;

    public EventModel(EventForm form, List<User> eventManager) {
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
        this.eventManager = eventManager;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", country='" + country + '\'' +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", participantNumber=" + participantNumber +
                ", price=" + price +
                ", timeLog=" + timeLog +
                '}';
    }
}
