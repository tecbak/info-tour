package ua.rud.infotour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rud.infotour.domain.Agent;
import ua.rud.infotour.domain.Hotel;
import ua.rud.infotour.domain.Tour;
import ua.rud.infotour.repository.AgentRepository;
import ua.rud.infotour.repository.TourRepository;
import ua.rud.infotour.service.HotelService;
import ua.rud.infotour.service.TourService;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final HotelService hotelService;
    private final AgentRepository agentRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, HotelService hotelService, AgentRepository agentRepository) {
        this.tourRepository = tourRepository;
        this.hotelService = hotelService;
        this.agentRepository = agentRepository;
    }

    @Override
    public Tour createTour() {
        Tour tour = new Tour();
        return tourRepository.saveAndFlush(tour);
    }

    @Override
    public Tour getById(Long tourId) {
        return tourRepository.getById(tourId);
    }

//    @Override
//    public Tour addHotel(Long tourId, Long hotelId) {
//        Tour tour = tourRepository.getById(tourId);
//        Hotel hotel = hotelService.getById(hotelId);
//        tour.addHotel(hotel);
//        return tourRepository.saveAndFlush(tour);
//    }
//
//    @Override
//    public Tour addAgent(Long tourId, Long agentId) {
//        Tour tour = tourRepository.getById(tourId);
//        Agent agent = agentRepository.getById(agentId);
//        tour.addAgent(agent);
//        return tourRepository.saveAndFlush(tour);
//    }

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }
}
