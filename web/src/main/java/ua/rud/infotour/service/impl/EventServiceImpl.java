package ua.rud.infotour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.rud.infotour.domain.schedule.Event;
import ua.rud.infotour.dto.NewEventDto;
import ua.rud.infotour.repository.EventRepository;
import ua.rud.infotour.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event addEvent(NewEventDto eventDto) {
        Event event = new Event(eventDto);
        return eventRepository.saveAndFlush(event);
    }
}
