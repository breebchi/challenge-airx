package com.airxelerate.challenge.controller;

import com.airxelerate.challenge.controller.mapper.FlightMapper;
import com.airxelerate.challenge.datatransferobject.FlightDTO;
import com.airxelerate.challenge.domainobject.FlightDO;
import com.airxelerate.challenge.exception.ConstraintsViolationException;
import com.airxelerate.challenge.exception.EntityNotFoundException;
import com.airxelerate.challenge.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This rest controllers presents endpoints to be called upon to acquire a resource.
 */
@RestController
@Validated
@RequestMapping("v1/flights")
public class FlightController
{
    private final FlightService flightService;


    @Autowired
    public FlightController(FlightService flightService)
    {
        this.flightService = flightService;
    }


    @GetMapping("/{id}")
    public FlightDTO findFlight(@PathVariable @NotNull Long id) throws EntityNotFoundException
    {
        return FlightMapper.makeFlightDTO(flightService.find(id));
    }


    @GetMapping
    public List<FlightDTO> findAll()
    {
        return FlightMapper.makeFlightDTOList(flightService.find());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightDTO createFlight(@Valid @RequestBody FlightDTO flightDTO) throws ConstraintsViolationException
    {
        FlightDO flightDO = FlightMapper.makeFlightDO(flightDTO);
        return FlightMapper.makeFlightDTO(flightService.create(flightDO));
    }


    @DeleteMapping("/{flightId}")
    public void deleteFlight(@PathVariable long flightId) throws EntityNotFoundException
    {
        flightService.delete(flightId);
    }
}
