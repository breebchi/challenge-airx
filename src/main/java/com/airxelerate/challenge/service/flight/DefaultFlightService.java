package com.airxelerate.challenge.service.flight;

import com.airxelerate.challenge.dataaccessobject.FlightRepository;
import com.airxelerate.challenge.domainobject.FlightDO;
import com.airxelerate.challenge.exception.ConstraintsViolationException;
import com.airxelerate.challenge.exception.EntityNotFoundException;
import com.airxelerate.challenge.service.FlightService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This is a class that services the endpoint's requests
 */
@Service
public class DefaultFlightService implements FlightService
{
    private final FlightRepository flightRepository;


    public DefaultFlightService(FlightRepository flightRepository)
    {
        this.flightRepository = flightRepository;
    }


    @Transactional
    @Override
    public FlightDO find(Long flightId) throws EntityNotFoundException
    {
        return findFlightChecked(flightId);
    }


    @Transactional
    @Override
    public List<FlightDO> find()
    {
        return flightRepository.findAll();
    }


    @Transactional
    @Override
    public FlightDO create(FlightDO flightDO) throws ConstraintsViolationException
    {
        FlightDO flight;
        try
        {
            flight = flightRepository.save(flightDO);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new ConstraintsViolationException("ConstraintsViolationException while creating a flight: " + flightDO, e);
        }
        return flight;
    }


    @Transactional
    @Override
    public void delete(Long flightId) throws EntityNotFoundException
    {
        FlightDO flightDO = findFlightChecked(flightId);
        flightRepository.delete(flightDO);
    }


    private FlightDO findFlightChecked(Long flightId) throws EntityNotFoundException
    {
        return flightRepository.findById(flightId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + flightId));
    }
}
