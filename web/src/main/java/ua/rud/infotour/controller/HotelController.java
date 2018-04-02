package ua.rud.infotour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.rud.infotour.domain.Hotel;
import ua.rud.infotour.service.HotelService;

@RestController
@RequestMapping("hotel/")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "add/{name}", method = RequestMethod.POST)
    public ResponseEntity<Hotel> addHotel(@PathVariable("name") String name) {
        Hotel hotel = hotelService.addHotel(name);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
}
