package ua.rud.infotour.service;

import ua.rud.infotour.domain.Hotel;

import java.util.UUID;

public interface HotelService {
    Hotel addHotel(String name);

    Hotel getById(UUID id);
}
