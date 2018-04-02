package ua.rud.infotour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.rud.infotour.domain.schedule.Event;
import ua.rud.infotour.dto.NewEventDto;
import ua.rud.infotour.service.EventService;

@RestController
@RequestMapping("event")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(path = "add", method = RequestMethod.POST)
    public ResponseEntity<Event> createEvent(@RequestBody NewEventDto eventDto) {
        Event event = eventService.addEvent(eventDto);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
