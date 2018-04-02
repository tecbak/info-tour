package ua.rud.infotour.service;

import ua.rud.infotour.domain.Tour;
import ua.rud.infotour.dto.NewEventDto;

import java.util.List;
import java.util.UUID;

public interface TourService {
    Tour createTour();

    Tour getById(UUID tourId);

//    Tour addHotel(Long tourId, Long hotelId);

    List<Tour> getAll();

    Tour addPerson(UUID tourId, UUID personId);

    Tour addEvent(UUID tourId, NewEventDto eventDto);
}
