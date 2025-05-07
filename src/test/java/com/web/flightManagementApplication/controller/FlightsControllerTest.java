package com.web.flightManagementApplication.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(FlightsController.class)
public class FlightsControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @InjectMocks
//    private FlightImpService flightImpService;
//
//    @Test
//    public void testAllFlights() throws Exception {
//        Flight flight = new Flight();
//        flight.setTotalSeats(250);
//        flight.setFlightId(11);
//        List<Flight> allFLights = new ArrayList<>(Arrays.asList(flight));
//        Page<Flight> page = new PageImpl<>(allFLights);
//
//        Mockito.when(flightImpService.getFlights()).thenReturn(page);
//
//        mockMvc.perform(get("/flights"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").isArray())
//                .andExpect(jsonPath("$.content[0].flightId").value(11))
//                .andExpect(jsonPath("$.content[0].totalSeats").value(250));
//    }

}
