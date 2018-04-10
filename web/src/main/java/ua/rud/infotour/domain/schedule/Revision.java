package ua.rud.infotour.domain.schedule;

import org.hibernate.annotations.GenericGenerator;
import ua.rud.infotour.domain.Hotel;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "revision")
public class Revision implements Schedule {

    @Id
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    protected Revision() {
    }

    public Revision(Hotel hotel) {
        this.hotel = hotel;
    }

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
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
