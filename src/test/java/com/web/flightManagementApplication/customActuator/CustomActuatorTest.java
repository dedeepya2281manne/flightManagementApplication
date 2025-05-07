package com.web.flightManagementApplication.customActuator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomActuatorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testActuator(){
        

    }
}
