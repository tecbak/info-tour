package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.rud.infotour.domain.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    Tour getById(Long id);
}
