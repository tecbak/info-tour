package ua.rud.infotour.service;

import ua.rud.infotour.domain.schedule.Event;
import ua.rud.infotour.dto.NewEventDto;

public interface EventService {

    Event addEvent(NewEventDto eventDto);
}
