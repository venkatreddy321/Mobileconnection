package com.hackathon.mobileconnection.controller;

 

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

 

public class HealthControllerTest {
    
    @Mock
    private HealthController healthController;
    
    @Before
    public void setup() {
        healthController = new HealthController();
    }
    
    @Test
    public void testHealthController() {
        ResponseEntity<?> response = healthController.healthCheck();
        Assert.assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

 

}