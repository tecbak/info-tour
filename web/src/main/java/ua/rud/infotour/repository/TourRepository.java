package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.rud.infotour.domain.Tour;

import java.util.UUID;

@Repository
public interface TourRepository extends JpaRepository<Tour, UUID> {

    Tour getById(UUID id);
}
