package com.airxelerate.challenge.service.flight;

import com.airxelerate.challenge.dataaccessobject.FlightRepository;
import com.airxelerate.challenge.domainobject.FlightDO;
import com.airxelerate.challenge.exception.ConstraintsViolationException;
import com.airxelerate.challenge.exception.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DefaultFlightServiceTest
{
    // Here we tell Mockito to mock DefaultFlightService and to inject FlightRepository into it.
    @InjectMocks
    DefaultFlightService flightService;
    @Mock
    FlightRepository flightRepository;
    private Validator validator;


    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void findById() throws EntityNotFoundException
    {
        // Here we initialize a FlightDO object
        FlightDO flight = new FlightDO(LocalDateTime.now(), "NA", 1234, "MIR", "BXL");
        flight.setId(1L);
        // Here we tell Mockito what to we want the repository method that we call to return.
        when(flightRepository.findById(flight.getId())).thenReturn(Optional.of(flight));
        // Here we compare the results we got to the expected values.
        assertEquals(flight, flightService.find(flight.getId()));
    }


    @Test(expected = EntityNotFoundException.class)
    public void findByIdShouldThrowEntityNotFoundExceptionWhenFlightIsNotFound() throws EntityNotFoundException
    {
        // Since we do not tell Mockito what we want the repository method to return, it returns nothing, hence the EntityNotFoundException exception.
        flightService.find(1L);
    }


    @Test
    public void findAll()
    {
        // Here we initialize FlightDO objects
        List<FlightDO> flights = new ArrayList<>();
        flights.add(new FlightDO(LocalDateTime.now(), "MVA", 159, "MER", "BNL"));
        flights.add(new FlightDO(LocalDateTime.now(), "NA", 1234, "MIR", "BXL"));
        flights.add(new FlightDO(LocalDateTime.now(), "NNA", 1834, "MIX", "PXL"));
        // Here we tell Mockito what to we want the repository method that we call to return.
        when(flightRepository.findAll()).thenReturn(flights);
        // Here we compare the results we got to the expected values.
        assertEquals(3, flightService.find().size());
        assertEquals(flights, flightService.find());
    }


    @Test
    public void findShouldReturnEmptyListWhenNoFlightWasSpecified()
    {
        // Here we tell Mockito what to we want the repository method that we call to return
        when(flightRepository.findAll()).thenReturn(Collections.emptyList());
        // Here we compare the results we got to the expected values.
        assertEquals(0, flightService.find().size());
    }


    @Test
    public void create() throws ConstraintsViolationException
    {
        FlightDO flight = new FlightDO(LocalDateTime.now(), "NA", 1234, "MIR", "BXL");
        when(flightRepository.save(flight)).thenReturn(flight);
        assertEquals(flight, flightService.create(flight));
    }


    @Test
    public void createShouldThrowConstraintsViolationExceptionWhenFieldValueNotValid() throws ConstraintsViolationException
    {
        // flight number has 5 digits instead of five, hence the constraint violation and exception.
        FlightDO flight = new FlightDO(LocalDateTime.now(), "NA", 12345, "MIR", "BXL");
        when(flightRepository.save(flight)).thenReturn(flight);
        Set<ConstraintViolation<FlightDO>> violations = validator.validate(flightService.create(flight));
        assertEquals(1, violations.size());
    }


    @Test(expected = EntityNotFoundException.class)
    public void delete() throws EntityNotFoundException
    {
        FlightDO flight = new FlightDO(LocalDateTime.now(), "NA", 1234, "MIR", "BXL");
        flight.setId(1L);
        when(flightRepository.findById(flight.getId())).thenReturn(Optional.of(flight));
        flightService.delete(flight.getId());
        when(flightRepository.findById(flight.getId())).thenReturn(Optional.empty());
        flightService.find(flight.getId());
    }


    @Test(expected = EntityNotFoundException.class)
    public void deleteShouldThrowEntityNotFoundExceptionWhenFlightIsNotFound() throws EntityNotFoundException
    {
        flightService.delete(1L);
    }
}
