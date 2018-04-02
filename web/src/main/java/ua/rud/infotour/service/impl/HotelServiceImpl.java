package ua.rud.infotour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rud.infotour.domain.Hotel;
import ua.rud.infotour.repository.HotelRepository;
import ua.rud.infotour.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel addHotel(String name) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        return hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public Hotel getById(Long id) {
        return hotelRepository.getById(id);
    }
}
