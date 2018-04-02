package ua.rud.infotour.domain;

import org.hibernate.annotations.GenericGenerator;
import ua.rud.infotour.domain.schedule.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tour")
public class Tour implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    private Set<Event> schedules;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tour_person",
            joinColumns = {@JoinColumn(name = "tour_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")}
    )
    private Set<Person> people = new HashSet<>();

    public Tour() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Event> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Event> schedules) {
        this.schedules = schedules;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public boolean addPerson(Person person) {
        if (people == null) {
            people = new HashSet<>();
        }
        return people.add(person);
    }

    public boolean addEvent(Event event) {
        if (schedules == null) {
            schedules = new HashSet<Event>();
        }
        return schedules.add(event);
    }
}
