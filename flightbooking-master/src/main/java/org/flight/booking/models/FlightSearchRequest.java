package org.flight.booking.models;

import org.flight.booking.common.TravelClass;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class FlightSearchRequest {

    private String source;
    private String destination;
    private Integer passengerCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    private TravelClass travelClass;

    public FlightSearchRequest(String source, String destination, Integer passengerCount, LocalDate departureDate, TravelClass travelClass) {
        this.source = source;
        this.destination = destination;
        this.passengerCount = passengerCount;
        this.departureDate = departureDate;
        this.travelClass = travelClass;
    }

    public FlightSearchRequest() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getPassengerCountValue() {
        return this.passengerCount == null || this.passengerCount == 0 ? 1 : this.passengerCount;
    }

    public LocalDate getDepartureDateValue() {
        return (this.departureDate == null || " ".trim().equalsIgnoreCase(this.departureDate.toString().trim())) ? LocalDate.now() : this.getDepartureDate();
    }

    public TravelClass getTravelTypeValue() {
        return (null == travelClass || " ".trim().equalsIgnoreCase(travelClass.toString().trim()) ? TravelClass.ECONOMY : travelClass);
    }
}
