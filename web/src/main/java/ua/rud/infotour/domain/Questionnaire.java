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
    private Agent agent;

    @Column(name = "notes")
    private String notes;

    public static List<Questionnaire> create(List<Agent> agents) {
        return agents.stream()
                .map(Questionnaire::new)
                .collect(Collectors.toList());
    }

    protected Questionnaire() {
    }

    private Questionnaire(Agent agent) {
        this.agent = agent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }*/
}
