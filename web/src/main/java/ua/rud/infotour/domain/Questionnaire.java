package ua.rud.infotour.domain;

import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

//@Entity
//@Table(name = "questionnaire")
public class Questionnaire implements Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private Person agent;

    @Column(name = "notes")
    private String notes;

    public static List<Questionnaire> create(List<Person> agents) {
        return agents.stream()
                .map(Questionnaire::new)
                .collect(Collectors.toList());
    }

    protected Questionnaire() {
    }

    private Questionnaire(Person agent) {
        this.agent = agent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getAgent() {
        return agent;
    }

    public void setAgent(Person agent) {
        this.agent = agent;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }*/
}
