package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rud.infotour.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel getById(Long id);
}
