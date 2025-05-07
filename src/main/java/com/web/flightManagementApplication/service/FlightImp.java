package com.web.flightManagementApplication.service;

import com.web.flightManagementApplication.models.primary.Flight;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FlightImp {
    public Page<Flight> getFlights();

    List<Flight> getBySeats(int noOfSeats);

    List<Flight> getByAircraft(String aircraftType);

    List<Flight> getByPriceStatus(String price, String status);
}
