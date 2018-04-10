package ua.rud.infotour.domain;

import org.hibernate.annotations.GenericGenerator;
import ua.rud.infotour.domain.schedule.Event;
import ua.rud.infotour.domain.schedule.Revision;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tour")
@NamedEntityGraph(
        name = "tourWithSchedulesAndPeople",
        attributeNodes = {
                @NamedAttributeNode("revisions"),
                @NamedAttributeNode("events"),
                @NamedAttributeNode("people")
        }
)
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
    private Set<Revision> revisions = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    private Set<Event> events = new HashSet<>();

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

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Set<Revision> getRevisions() {
        return revisions;
    }

    public void setRevisions(Set<Revision> revisions) {
        this.revisions = revisions;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public boolean addPerson(Person person) {
        return people.add(person);
    }

    public boolean addEvent(Event event) {
        return events.add(event);
    }

    public boolean addRevision(Revision revision) {
        return revisions.add(revision);
    }
}
