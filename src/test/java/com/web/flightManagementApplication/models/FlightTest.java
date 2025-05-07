package com.web.flightManagementApplication.models;

import com.web.flightManagementApplication.models.primary.Flight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightTest {

    @Test
    public void testFlightModel(){
        Flight flight = new Flight();
        flight.setFlightId(1);
        flight.setFlightNumber("EK707");
        flight.setAirlineName("Emirates");
        flight.setDepartureDateTime(LocalDateTime.parse("2025-05-02T01:00:00"));
        flight.setArrivalDateTime(LocalDateTime.parse("2025-05-02T01:00:00"));
        flight.setDuration(120);
        flight.setAvailableSeats(200);
        flight.setStatus("On Time");
        flight.setPrice(BigDecimal.valueOf(20000.00));
        flight.setAircraftType("Boeing 777");
        flight.setGateNumber("G5");
        flight.setTotalSeats(250);

        assertEquals(1,flight.getFlightId());
        assertEquals("EK707", flight.getFlightNumber());
        assertEquals("Emirates",flight.getAirlineName());
        assertEquals(LocalDateTime.parse("2025-05-02T01:00:00"), flight.getDepartureDateTime());
        assertEquals(LocalDateTime.parse("2025-05-02T01:00:00"), flight.getArrivalDateTime());
        assertEquals(120, flight.getDuration());
        assertEquals(200, flight.getAvailableSeats());
        assertEquals("On Time", flight.getStatus());
        assertEquals(BigDecimal.valueOf(20000.00), flight.getPrice());
        assertEquals("Boeing 777", flight.getAircraftType());
        assertEquals("G5", flight.getGateNumber());
        assertEquals(250, flight.getTotalSeats());



    }
}
