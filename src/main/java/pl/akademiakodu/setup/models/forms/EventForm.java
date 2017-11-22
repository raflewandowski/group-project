package pl.akademiakodu.setup.models.forms;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Rafal Lewandowski on 03.11.2017.
 */

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventForm {

    @NotBlank
    @Size (min = 5, max = 50)
    private String title;
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "wrong date format")
    private String startDate;
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "wrong date format")
    private String endDate;
    @Pattern(regexp = "[0-2][0-9]:[0-5][0-9]", message = "wrong time format")
    private String startTime;
    @Pattern(regexp = "[0-2][0-9]:[0-5][0-9]", message = "wrong time format")
    private String endTime;
    @NotBlank
    @Size (min = 3, max = 30)
    private String country;
    @NotBlank
    @Size (min = 5, max = 40)
    private String location;
    @NotBlank
    @Size (min = 3, max = 30)
    private String city;
    @NotBlank
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "wrong post code format")
    private String postCode;
    @NotBlank
    @Size (min = 20, max = 500)
    private String description;
    @Min(value = 1)
    private int category; //int czy String?
    //private int eventClickCount;
    @Min(value = 1)
    private int participantNumber;
    //Image
    @Min(value = 1)
    @Max(value = Integer.MAX_VALUE)
    private int price;
    //Eventhost id
    //Participant id

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getFormatedStartDate(){
        return  LocalDate.parse(startDate, dateFormat);
    }

    public LocalDate getFormatedEndDate(){
        return  LocalDate.parse(endDate, dateFormat);
    }

    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    public LocalTime getFormatedStartTime(){
        return  LocalTime.parse(startTime, timeFormat);
    }

    public LocalTime getFormatedEndTime(){
        return  LocalTime.parse(endTime, timeFormat);
    }

}



