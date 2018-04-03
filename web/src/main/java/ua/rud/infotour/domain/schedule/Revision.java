package ua.rud.infotour.domain.schedule;

import org.hibernate.annotations.GenericGenerator;
import ua.rud.infotour.domain.Hotel;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "revision")
public class Revision extends Schedule {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }*/
    
    
    

    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    protected Revision() {
    }

    public Revision(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "date_time")
//    private LocalDateTime dateTime;
//
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
}
