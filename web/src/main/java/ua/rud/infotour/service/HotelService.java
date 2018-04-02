package ua.rud.infotour.service;

import ua.rud.infotour.domain.Hotel;

public interface HotelService {
    Hotel addHotel(String name);

    Hotel getById(Long id);
}
