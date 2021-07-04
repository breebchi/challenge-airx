package com.airxelerate.challenge.service;

import com.airxelerate.challenge.domainobject.FlightDO;
import com.airxelerate.challenge.exception.ConstraintsViolationException;
import com.airxelerate.challenge.exception.EntityNotFoundException;

import java.util.List;

/**
 * This interface represents a contract as to what logic a flight service class should implement.
 */
public interface FlightService
{
    FlightDO find(Long flightId) throws EntityNotFoundException;

    List<FlightDO> find();

    FlightDO create(FlightDO flightDO) throws ConstraintsViolationException;

    void delete(Long flightId) throws EntityNotFoundException;
}
