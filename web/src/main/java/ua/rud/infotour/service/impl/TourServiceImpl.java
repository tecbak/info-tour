package ua.rud.infotour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.rud.infotour.domain.Person;
import ua.rud.infotour.domain.Tour;
import ua.rud.infotour.domain.schedule.Event;
import ua.rud.infotour.dto.NewEventDto;
import ua.rud.infotour.repository.PersonRepository;
import ua.rud.infotour.repository.TourRepository;
import ua.rud.infotour.service.HotelService;
import ua.rud.infotour.service.TourService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final HotelService hotelService;
    private final PersonRepository personRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, HotelService hotelService, PersonRepository personRepository) {
        this.tourRepository = tourRepository;
        this.hotelService = hotelService;
        this.personRepository = personRepository;
    }

    @Override
    public Tour createTour() {
        Tour tour = new Tour();
        return tourRepository.saveAndFlush(tour);
    }

    @Override
    public Tour getById(UUID tourId) {
        return tourRepository.getById(tourId);
    }

    //    @Override
//    public Tour addHotel(UUID tourId, UUID hotelId) {
//        Tour tour = tourRepository.getById(tourId);
//        Hotel hotel = hotelService.getById(hotelId);
//        tour.addHotel(hotel);
//        return tourRepository.saveAndFlush(tour);
//    }
//
    @Override
    public Tour addPerson(UUID tourId, UUID agentId) {
        Tour tour = tourRepository.getById(tourId);
        Person person = personRepository.getById(agentId);
        tour.addPerson(person);
        return tourRepository.saveAndFlush(tour);
    }

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour addEvent(UUID tourId, NewEventDto eventDto) {
        Tour tour = tourRepository.getById(tourId);
        Event event = new Event(eventDto);
        tour.addEvent(event);
        return tourRepository.saveAndFlush(tour);
    }
}
