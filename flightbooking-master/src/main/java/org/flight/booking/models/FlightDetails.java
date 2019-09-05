package org.flight.booking.models;

import org.flight.booking.common.Seats;

public class FlightDetails {

    private String flightNo;
    private String flightName;
    private String origin;
    private String destination;
    private Seats seatsAndPrice;

    public FlightDetails(String flightNo, String flightName, String origin, String destination, Seats seatsAndPrice) {
        this.flightNo = flightNo;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.seatsAndPrice = seatsAndPrice;
    }

    public FlightDetails(String flightNo, String flightName, String origin, String destination) {
        this.flightNo = flightNo;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
    }

    public FlightDetails() {

    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Seats getSeatsAndPrice() {
        return seatsAndPrice;
    }

    public void setSeatsAndPrice(Seats seatsAndPrice) {
        this.seatsAndPrice = seatsAndPrice;
    }
}

