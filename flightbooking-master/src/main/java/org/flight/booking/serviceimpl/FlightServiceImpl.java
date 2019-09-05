package org.flight.booking.serviceimpl;

import org.flight.booking.common.Status;
import org.flight.booking.models.FlightDetails;
import org.flight.booking.models.FlightEntity;
import org.flight.booking.models.FlightSearchRequest;
import org.flight.booking.models.FlightSearchResponse;
import org.flight.booking.repository.FlightRepository;
import org.flight.booking.service.FlightService;
import org.flight.booking.util.FlightServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository repository;

    @Override
    public List<FlightDetails> availableFlights() {
        return repository.availableFlights();
    }

    @Override
    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        List<FlightDetails> allFlights = repository.availableFlights();
        FlightSearchResponse response = new FlightSearchResponse();

        List<FlightDetails> flightSchedules = allFlights.stream()
                .filter(schedule -> schedule.getOrigin().equals(request.getSource()) &&
                        schedule.getDestination().equals(request.getDestination()) &&
                        FlightServiceUtil.flightsAvailabilityCheckOnDate(request) &&
                        FlightServiceUtil.flightsSeatsAvailabilityCheck(schedule, request)).collect(Collectors.toList());

        List<FlightEntity> matchedFlights = flightSchedules.stream()
                .map(schedule -> FlightServiceUtil.getFlightEntity(schedule, request))
                .collect(Collectors.toList());

        if (null != matchedFlights && matchedFlights.size() != 0) {
            response.setStatus(Status.SUCCESS);
            response.setAvailableFlights(matchedFlights);
        }
        else {
            response.setStatus(Status.FAILURE);
            response.setMessage("Sorry, no flights available");
        }
        return response;
    }
}