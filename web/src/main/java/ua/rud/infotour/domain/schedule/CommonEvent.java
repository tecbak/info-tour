package ua.rud.infotour.domain.schedule;

import javax.persistence.*;

@Entity
@Table(name = "common_event")
public class CommonEvent extends Schedule {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;

//    @Column(name = "date_time")
//    private LocalDateTime dateTime;

    @Column(name = "information")
    private String information;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public LocalDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(LocalDateTime dateTime) {
//        this.dateTime = dateTime;
//    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
