package org.flight.booking.repository;

import org.flight.booking.common.Seats;
import org.flight.booking.common.TravelClass;
import org.flight.booking.common.TravelClassSeatsAndPrice;
import org.flight.booking.models.FlightDetails;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FlightRepository {

    public List<FlightDetails> availableFlights() {

        FlightDetails flight1 = new FlightDetails("F0001", "Boeing 777-200LR(77L)", "Hyderabad", "Delhi");

        Seats f1_Seats = new Seats();

        Map<TravelClass, TravelClassSeatsAndPrice> seatsAndPriceMap_1 = new HashMap<>();
        seatsAndPriceMap_1.put(TravelClass.FIRST, getTravelClassSeatsAndPrice(8, 20000));
        seatsAndPriceMap_1.put(TravelClass.BUSINESS, getTravelClassSeatsAndPrice(35, 13000));
        seatsAndPriceMap_1.put(TravelClass.ECONOMY, getTravelClassSeatsAndPrice(195, 6000));

        f1_Seats.setTotalSeats(238);
        f1_Seats.setTravelClassInfo(seatsAndPriceMap_1);

        flight1.setSeatsAndPrice(f1_Seats);

        FlightDetails flight2 = new FlightDetails("F0002", "Airbus A319 V2", "Hyderabad", "Delhi");

        Seats f2_Seats = new Seats();

        Map<TravelClass, TravelClassSeatsAndPrice> seatsAndPriceMap_2 = new HashMap<>();
        seatsAndPriceMap_2.put(TravelClass.ECONOMY, getTravelClassSeatsAndPrice(144, 4000));

        f2_Seats.setTotalSeats(144);
        f2_Seats.setTravelClassInfo(seatsAndPriceMap_2);

        flight2.setSeatsAndPrice(f2_Seats);

        FlightDetails flight3 = new FlightDetails("F0003", "Airbus A321", "Hyderabad", "Delhi");

        Seats f3_Seats = new Seats();

        Map<TravelClass, TravelClassSeatsAndPrice> seatsAndPriceMap_3 = new HashMap<>();
        seatsAndPriceMap_3.put(TravelClass.BUSINESS, getTravelClassSeatsAndPrice(20, 10000));
        seatsAndPriceMap_3.put(TravelClass.ECONOMY, getTravelClassSeatsAndPrice(152, 5000));

        f3_Seats.setTotalSeats(172);
        f3_Seats.setTravelClassInfo(seatsAndPriceMap_3);

        flight3.setSeatsAndPrice(f3_Seats);

        List<FlightDetails> flightDetailsList = Arrays.asList(flight1, flight2, flight3);

        return flightDetailsList;
    }

    private TravelClassSeatsAndPrice getTravelClassSeatsAndPrice(Integer seats, Integer basePrice) {
        return new TravelClassSeatsAndPrice(seats, basePrice);
    }
}
