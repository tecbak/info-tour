package ua.rud.infotour.service;

import ua.rud.infotour.domain.Tour;

import java.util.List;

public interface TourService {
    Tour createTour();

    Tour getById(Long tourId);

//    Tour addHotel(Long tourId, Long hotelId);

    List<Tour> getAll();

//    Tour addAgent(Long tourId, Long agentId);
}
