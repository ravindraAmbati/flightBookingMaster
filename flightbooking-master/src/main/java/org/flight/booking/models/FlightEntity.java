package org.flight.booking.models;

import org.flight.booking.common.TravelClass;

import java.time.LocalDate;

public class FlightEntity {

    private String flightNo;
    private String name;
    private String origin;
    private String destination;
    private LocalDate departureDate;

    private TravelClass travelType;
    private double totalFare;

    public FlightEntity(String flightNo, String name, String origin, String destination, LocalDate departureDate, TravelClass travelType, double totalFare) {
        this.flightNo = flightNo;
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.travelType = travelType;
        this.totalFare = totalFare;
    }

    public FlightEntity() {
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public TravelClass getTravelType() {
        return travelType;
    }

    public void setTravelType(TravelClass travelType) {
        this.travelType = travelType;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
}
