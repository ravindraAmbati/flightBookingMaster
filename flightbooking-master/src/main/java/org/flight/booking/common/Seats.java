package org.flight.booking.common;

import java.util.Map;

public class Seats {

    private Integer totalSeats;
    private Map<TravelClass, TravelClassSeatsAndPrice> travelClassInfo;

    public Seats(Integer totalSeats, Map<TravelClass, TravelClassSeatsAndPrice> travelClassInfo) {
        this.totalSeats = totalSeats;
        this.travelClassInfo = travelClassInfo;
    }

    public Seats() {
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Map<TravelClass, TravelClassSeatsAndPrice> getTravelClassInfo() {
        return travelClassInfo;
    }

    public void setTravelClassInfo(Map<TravelClass, TravelClassSeatsAndPrice> travelClassInfo) {
        this.travelClassInfo = travelClassInfo;
    }
}
