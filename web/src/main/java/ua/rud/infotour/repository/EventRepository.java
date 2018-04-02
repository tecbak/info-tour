package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rud.infotour.domain.schedule.Event;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

}
