package ua.rud.infotour.domain.schedule;

import org.hibernate.annotations.GenericGenerator;
import ua.rud.infotour.dto.NewEventDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "event")
public class Event extends Schedule{

//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    @Column(name = "id")
//    private UUID id;
//
//    @Column(name = "date_time")
//    private LocalDateTime dateTime;

    @Column(name = "information")
    private String information;

    public Event() {
    }

    public Event(NewEventDto eventDto) {
        String information = eventDto.getInformation();
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
