package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rud.infotour.domain.Person;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person getById(UUID id);

    Person getByName(String name);
}
