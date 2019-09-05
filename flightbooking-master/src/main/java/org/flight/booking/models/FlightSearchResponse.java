package org.flight.booking.models;

import org.flight.booking.common.Status;

import java.util.List;

public class FlightSearchResponse extends AbstractResponse {

    private List<FlightEntity> availableFlights;

    public FlightSearchResponse(Status status, String message, List<FlightEntity> availableFlights) {
        super(status, message);
        this.availableFlights = availableFlights;
    }

    public FlightSearchResponse(List<FlightEntity> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public FlightSearchResponse() {
    }

    public List<FlightEntity> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(List<FlightEntity> availableFlights) {
        this.availableFlights = availableFlights;
    }
}
