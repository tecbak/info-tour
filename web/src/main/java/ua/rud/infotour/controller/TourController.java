package ua.rud.infotour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.rud.infotour.domain.Tour;
import ua.rud.infotour.dto.NewEventDto;
import ua.rud.infotour.service.TourService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tour")
public class TourController {
    private TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<Tour> createTour() {
        Tour newTour = tourService.createTour();
        return new ResponseEntity<>(newTour, HttpStatus.OK);
    }

    @PostMapping(value = "{tour_id}/add-hotel/{hotel_id}")
    public ResponseEntity<Tour> addHotel(@PathVariable("tour_id") UUID tourId, @PathVariable("hotel_id") UUID hotelId) {
        throw new UnsupportedOperationException();
//        Tour tour = tourService.addHotel(tourId, hotelId);
//        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @PostMapping(value = "{tour_id}/add-agent/{person_id}")
    public ResponseEntity<Tour> addPerson(@PathVariable("tour_id") UUID tourId, @PathVariable("person_id") UUID personId) {
        Tour tour = tourService.addPerson(tourId, personId);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @GetMapping(value = "{tour_id}")
    public ResponseEntity<Tour> getById(@PathVariable("tour_id") UUID tourId) {
        Tour tour = tourService.getById(tourId);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<Tour>> getAll() {
        List<Tour> tours = tourService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @PostMapping(value = "{tour_id}/add-event")
    public ResponseEntity<Tour> addEvent(@PathVariable("tour_id") UUID tourId, 
                                         @RequestBody NewEventDto eventDto) {
        Tour tour = tourService.addEvent(tourId, eventDto);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }
}
