package org.flight.booking.service;

import org.flight.booking.models.FlightDetails;
import org.flight.booking.models.FlightSearchRequest;
import org.flight.booking.models.FlightSearchResponse;

import java.util.List;

public interface FlightService {

    public List<FlightDetails> availableFlights();

    public FlightSearchResponse searchFlights(FlightSearchRequest request);
}
