package org.flight.booking.controller;

import org.flight.booking.models.FlightDetails;
import org.flight.booking.models.FlightSearchRequest;
import org.flight.booking.models.FlightSearchResponse;
import org.flight.booking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/flight")
@RestController
@CrossOrigin("http://localhost:3000")
public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/availableflights")
    public List<FlightDetails> availableFlights() {
        return service.availableFlights();
    }

    @PostMapping("/searchflights")
    public FlightSearchResponse searchFlights(@RequestBody FlightSearchRequest request) {
        return service.searchFlights(request);
    }
}
