package ua.rud.infotour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.rud.infotour.domain.Tour;
import ua.rud.infotour.service.TourService;

import java.util.List;

@RestController
@RequestMapping("tour")
public class TourController {
    private TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Tour> createTour() {
        Tour newTour = tourService.createTour();
        return new ResponseEntity<>(newTour, HttpStatus.OK);
    }

    @RequestMapping(value = "{tour_id}/add-hotel/{hotel_id}", method = RequestMethod.POST)
    public ResponseEntity<Tour> addHotel(@PathVariable("tour_id") Long tourId, @PathVariable("hotel_id") Long hotelId) {
        throw new UnsupportedOperationException();
//        Tour tour = tourService.addHotel(tourId, hotelId);
//        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @RequestMapping(value = "{tour_id}/add-agent/{agent_id}", method = RequestMethod.POST)
    public ResponseEntity<Tour> addAgent(@PathVariable("tour_id") Long tourId, @PathVariable("agent_id") Long agentId) {
        throw new UnsupportedOperationException();
//        Tour tour = tourService.addAgent(tourId, agentId);
//        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @RequestMapping(value = "{tour_id}", method = RequestMethod.GET)
    public ResponseEntity<Tour> getById(@PathVariable("tour_id") Long tourId) {
        Tour tour = tourService.getById(tourId);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<List<Tour>> getAll() {
        List<Tour> tours = tourService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }


}
