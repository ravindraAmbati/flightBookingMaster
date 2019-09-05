package org.flight.booking.util;

import org.flight.booking.common.TravelClass;
import org.flight.booking.common.TravelClassSeatsAndPrice;
import org.flight.booking.models.FlightDetails;
import org.flight.booking.models.FlightEntity;
import org.flight.booking.models.FlightSearchRequest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class FlightServiceUtil {

    public static double calculateTotalFare(FlightDetails flightDetails, FlightSearchRequest request) {
        if (request.getTravelTypeValue() == TravelClass.FIRST) {
            return firstClassFare(flightDetails, request);
        }
        else if (request.getTravelTypeValue() == TravelClass.BUSINESS) {
            return businessClassFare(flightDetails, request);
        }
        else {
            return economyClassFare(flightDetails, request);
        }
    }

    public static boolean flightsSeatsAvailabilityCheck(FlightDetails flightDetails, FlightSearchRequest request) {
        TravelClassSeatsAndPrice travelClassSeatsAndPrice = flightDetails.getSeatsAndPrice().getTravelClassInfo().get(request.getTravelTypeValue());
        return travelClassSeatsAndPrice != null && travelClassSeatsAndPrice.getNoOfSeats() >=
                request.getPassengerCountValue();
    }

    public static boolean flightsAvailabilityCheckOnDate(FlightSearchRequest request) {
        if (request.getTravelTypeValue() == TravelClass.FIRST) {
            return Period.between(LocalDate.now(), request.getDepartureDateValue()).getDays() < 10
                    && Period.between(LocalDate.now(), request.getDepartureDateValue()).getDays() >= 0;
        }
        else if (request.getTravelTypeValue() == TravelClass.BUSINESS) {
            return Period.between(LocalDate.now(), request.getDepartureDateValue()).getDays() <= 28
                    && Period.between(LocalDate.now(), request.getDepartureDateValue()).getDays() >= 0;
        }
        else {
            return true;
        }
    }

    public static double firstClassFare(FlightDetails flightDetails, FlightSearchRequest request) {
        double basePrice = flightDetails.getSeatsAndPrice().getTravelClassInfo().get(request.getTravelTypeValue()).getBaseFire();
        int noOfDays = Period.between(LocalDate.now(), request.getDepartureDateValue()).getDays();
        double newPrice = basePrice + ((10 - noOfDays) * 0.1 * basePrice);
        return newPrice * request.getPassengerCountValue();
    }

    public static double businessClassFare(FlightDetails flightDetails, FlightSearchRequest request) {
        double basePrice = flightDetails.getSeatsAndPrice().getTravelClassInfo().get(request.getTravelTypeValue()).getBaseFire();
        DayOfWeek week = request.getDepartureDateValue().getDayOfWeek();
        return ((week == DayOfWeek.MONDAY) || (week == DayOfWeek.FRIDAY) || (week == DayOfWeek.SUNDAY))
                ? ((basePrice + (0.4 * basePrice)) * request.getPassengerCountValue())
                : (basePrice * request.getPassengerCountValue());
    }

    public static double economyClassFare(FlightDetails flightDetails, FlightSearchRequest request) {
        double basePrice = flightDetails.getSeatsAndPrice().getTravelClassInfo().get(request.getTravelTypeValue()).getBaseFire();
        int totalSeats = flightDetails.getSeatsAndPrice().getTotalSeats();
        int availableSeats = 120; // Assumed for economy class

        double surCharge = 0;

        int first_forty = (int) (totalSeats - (totalSeats * 0.4));
        int next_fifty = (int) ((totalSeats) - (totalSeats * 0.5));

        if (availableSeats >= first_forty && availableSeats <= totalSeats) {
            surCharge = 0;
        }
        if (availableSeats < (first_forty) && availableSeats >= next_fifty) {
            surCharge = basePrice * 0.3;
        }
        if (availableSeats < (next_fifty) && availableSeats >= 1) {
            surCharge = basePrice * 0.6;
        }

        return ((basePrice + surCharge) * request.getPassengerCountValue());
    }

    public static FlightEntity getFlightEntity(FlightDetails flightDetails, FlightSearchRequest request) {
        FlightEntity flightEntity = null;

        if (null != flightDetails) {
            flightEntity = new FlightEntity();
            flightEntity.setFlightNo(flightDetails.getFlightNo());
            flightEntity.setName(flightDetails.getFlightName());
            flightEntity.setOrigin(request.getSource());
            flightEntity.setDestination(request.getDestination());
            flightEntity.setTravelType(request.getTravelTypeValue());
            flightEntity.setTotalFare(calculateTotalFare(flightDetails, request));
        }
        return flightEntity;
    }
}
