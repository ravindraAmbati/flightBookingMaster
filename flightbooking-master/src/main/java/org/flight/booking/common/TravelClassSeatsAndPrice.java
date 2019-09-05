package org.flight.booking.common;

public class TravelClassSeatsAndPrice {

    private Integer noOfSeats;
    private Integer baseFire;

    public TravelClassSeatsAndPrice(Integer noOfSeats, Integer baseFire) {
        this.noOfSeats = noOfSeats;
        this.baseFire = baseFire;
    }

    public TravelClassSeatsAndPrice() {
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Integer getBaseFire() {
        return baseFire;
    }

    public void setBaseFire(Integer baseFire) {
        this.baseFire = baseFire;
    }
}
