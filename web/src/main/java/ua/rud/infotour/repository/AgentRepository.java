package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rud.infotour.domain.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent getById(Long id);
}
