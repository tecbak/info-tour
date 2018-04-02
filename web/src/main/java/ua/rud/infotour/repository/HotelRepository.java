package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rud.infotour.domain.Hotel;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {

    Hotel getById(UUID id);
}
