package com.web.flightManagementApplication.globalException;

import org.junit.jupiter.api.Test;

public class ErrorResponseTest {

    @Test
    public void testConstructor(){
        ErrorResponse errorResponse = new ErrorResponse("Error Occured", "Error in test");
    }
}
