package com.web.flightManagementApplication.repository.primary;

import com.web.flightManagementApplication.models.primary.Flight;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("select f from Flight f where f.availableSeats >= :noOfSeats")
    List<Flight> getByNoOfSeats(@Param("noOfSeats") int noOfSeats);

    @Query(nativeQuery = true, value = "SELECT * FROM flights WHERE aircraft_type=?1")
    List<Flight> getByAirCraft(String aircraftType);

    @Query("select f from Flight f where f.price >= :price and status = status")
    List<Flight> getByPriceStatus(@Param("price") String price, @Param("status") String status, PageRequest departureDateTime);
}
