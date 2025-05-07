package com.web.flightManagementApplication.service;

import com.web.flightManagementApplication.models.primary.Flight;
import com.web.flightManagementApplication.repository.primary.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightImpService implements FlightImp{

    @Autowired
    FlightRepository flightRepository;

    @Override
    public Page<Flight> getFlights() {
        return flightRepository.findAll(PageRequest.of(1,5, Sort.by("departureDateTime").descending()));
    }

    @Override
    public List<Flight> getBySeats(int noOfSeats) {
        return flightRepository.getByNoOfSeats(noOfSeats);
    }

    @Override
    public List<Flight> getByAircraft(String aircraftType) {
        return flightRepository.getByAirCraft(aircraftType);
    }


    public List<Flight> getByPriceStatus(String price, String status) {
        return flightRepository.getByPriceStatus(price, status,PageRequest.of(1,5, Sort.by("departureDateTime").descending()));
    }
}
