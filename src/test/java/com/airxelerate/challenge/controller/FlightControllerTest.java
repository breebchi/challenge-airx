package com.airxelerate.challenge.controller;

import com.airxelerate.challenge.datatransferobject.FlightDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FlightControllerTest
{
    private static final String FLIGHT_CONTROLLER_PATH = "/api/flights";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;


    @Test
    @WithMockUser(authorities = {"ROLE_USER"})
    public void findById() throws Exception
    {
        String endpointPath = "/{flightId}";
        // This reflects a flight object that's already saved in DB
        FlightDTO flight = FlightDTO.newBuilder()
            .setId(1L)
            .setIataCarrierCode("AZ")
            .setFlightNumber(123)
            .setIataOriginCode("BRU")
            .setIataDestinationCode("SXF")
            .createFlightDTO();

        mockMvc.perform(get(FLIGHT_CONTROLLER_PATH + endpointPath, flight.getId())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(flight.getId()))
            .andExpect(jsonPath("$.iataCarrierCode").value(flight.getIataCarrierCode()))
            .andExpect(jsonPath("$.flightNumber").value(flight.getFlightNumber()))
            .andExpect(jsonPath("$.iataOriginCode").value(flight.getIataOriginCode()))
            .andExpect(jsonPath("$.iataDestinationCode").value(flight.getIataDestinationCode()));
    }


    @Test
    @WithMockUser(authorities = {"ROLE_ADMIN"})
    public void createFlight() throws Exception
    {
        FlightDTO flight = FlightDTO.newBuilder()
            .setIataCarrierCode("AZT")
            .setFlightDate(LocalDateTime.now())
            .setFlightNumber(1263)
            .setIataOriginCode("BIU")
            .setIataDestinationCode("SYH")
            .createFlightDTO();

        mockMvc.perform(post(FLIGHT_CONTROLLER_PATH)
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(flight)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.iataCarrierCode").value(flight.getIataCarrierCode()))
            .andExpect(jsonPath("$.flightNumber").value(flight.getFlightNumber()))
            .andExpect(jsonPath("$.iataOriginCode").value(flight.getIataOriginCode()))
            .andExpect(jsonPath("$.iataDestinationCode").value(flight.getIataDestinationCode()));
    }


    @Test
    @WithMockUser(authorities = {"ROLE_ADMIN"})
    public void deleteFlight() throws Exception
    {
        String endpointPath = "/{flightId}";

        mockMvc.perform(delete(FLIGHT_CONTROLLER_PATH + endpointPath, 1)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        mockMvc.perform(delete(FLIGHT_CONTROLLER_PATH + endpointPath, 1)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }
}
