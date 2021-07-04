package com.airxelerate.challenge.controller.mapper;

import com.airxelerate.challenge.datatransferobject.FlightDTO;
import com.airxelerate.challenge.domainobject.FlightDO;

import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper
{

    private FlightMapper()
    {
        throw new IllegalStateException("Utility class");
    }


    public static FlightDO makeFlightDO(FlightDTO flightDTO)
    {
        return new FlightDO(flightDTO.getFlightDate(), flightDTO.getIataCarrierCode(),
            flightDTO.getFlightNumber(), flightDTO.getIataOriginCode(), flightDTO.getIataDestinationCode());
    }


    public static FlightDTO makeFlightDTO(FlightDO flightDO)
    {
        return FlightDTO.newBuilder()
            .setId(flightDO.getId())
            .setFlightDate(flightDO.getFlightDate())
            .setFlightNumber(flightDO.getFlightNumber())
            .setIataCarrierCode(flightDO.getIataCarrierCode())
            .setIataDestinationCode(flightDO.getIataDestinationCode())
            .setIataOriginCode(flightDO.getIataOriginCode())
            .createFlightDTO();
    }


    public static List<FlightDTO> makeFlightDTOList(List<FlightDO> flights)
    {
        return flights.stream()
            .map(FlightMapper::makeFlightDTO)
            .collect(Collectors.toList());
    }
}
