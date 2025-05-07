package com.web.flightManagementApplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.web.flightManagementApplication.models.primary.Flight;
import com.web.flightManagementApplication.service.FlightImpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/app")
@Slf4j
public class FlightsController {
    private static final Logger logger = LoggerFactory.getLogger("reqRes");

    @Autowired
    private FlightImpService flightImpService;

    @GetMapping("/flights")
    public ResponseEntity<Page<Flight>> allFlights() throws JsonProcessingException {
        logger.info("endpoint /flights request to get all the flights from database");
        Page<Flight> flights = flightImpService.getFlights();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String responseJson = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(flights);
        logger.info("/flights endpoint response: " + responseJson );
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/flights/searchByseats")
    public ResponseEntity<List<Flight>> flightsBySeats(@RequestParam("seats") Integer seats) throws JsonProcessingException {
        logger.info("endpoint /flights/searchByseats request to get all the flights from database having greater than or equal to "+ seats + " seats");
        List<Flight> flights = flightImpService.getBySeats(seats);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String responseJson = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(flights);
        logger.info("/flights/searchByseats endpoint response: " + responseJson );
        return ResponseEntity.ok(flights);
    }
    @GetMapping("/flights/searchByaircrafttype")
    public ResponseEntity<List<Flight>> flightsByAirCraftType(@RequestParam("aircraftType") String aircraftType) throws JsonProcessingException {
        logger.info("endpoint /flights/searchByaircrafttype request to get all the flights from database having "+ aircraftType + " seats");
        List<Flight> flights = flightImpService.getByAircraft(aircraftType);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String responseJson = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(flights);
        logger.info("/flights/searchByaircrafttype endpoint response: " + responseJson );
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/flights/searchByPriceStatus")
    public ResponseEntity<List<Flight>> flightsByPriceOnTime(@RequestParam("price") String price,
                                                             @RequestParam("status") String status) throws JsonProcessingException {
        logger.info("endpoint /flights/searchByPriceStatus request to get all the flights from database having "+ price +" price " +status+ " status");
        List<Flight> flights = flightImpService.getByPriceStatus(price, status);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String responseJson = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(flights);
        logger.info("/flights/searchByaircrafttype endpoint response: {}", responseJson);

        return ResponseEntity.ok(flights);
    }




}
