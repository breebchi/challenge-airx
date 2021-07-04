package com.airxelerate.challenge.datatransferobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * This class offers a data transfers object for a flight.
 */
public class FlightDTO
{
    @ApiModelProperty(value = "Id of the flight.")
    private Long id;
    @NotNull(message = "Flight date can not be null!")
    @ApiModelProperty(value = "Flight date.")
    private LocalDateTime flightDate;
    @NotNull(message = "IATA carrier code can not be null!")
    @ApiModelProperty(value = "IATA carrier code.")
    private String iataCarrierCode;
    @NotNull(message = "Flight number can not be null!")
    @ApiModelProperty(value = "Flight number.")
    private Integer flightNumber;
    @NotNull(message = "IATA origin code can not be null!")
    @ApiModelProperty(value = "IATA origin code.")
    private String iataOriginCode;
    @NotNull(message = "IATA destination code can not be null!")
    @ApiModelProperty(value = "IATA destination code.")
    private String iataDestinationCode;


    public FlightDTO()
    {
    }


    // This is private because we want to enforce the use of the builder.
    private FlightDTO(Long id, LocalDateTime flightDate, String iataCarrierCode, Integer flightNumber, String iataOriginCode, String iataDestinationCode)
    {
        this.id = id;
        this.flightDate = flightDate;
        this.iataCarrierCode = iataCarrierCode;
        this.flightNumber = flightNumber;
        this.iataOriginCode = iataOriginCode;
        this.iataDestinationCode = iataDestinationCode;
    }


    // This is to acquire a builder
    public static FlightDTOBuilder newBuilder()
    {
        return new FlightDTOBuilder();
    }


    @JsonProperty
    public Long getId()
    {
        return id;
    }


    public LocalDateTime getFlightDate()
    {
        return flightDate;
    }


    public String getIataCarrierCode()
    {
        return iataCarrierCode;
    }


    public Integer getFlightNumber()
    {
        return flightNumber;
    }


    public String getIataOriginCode()
    {
        return iataOriginCode;
    }


    public String getIataDestinationCode()
    {
        return iataDestinationCode;
    }


    public static final class FlightDTOBuilder
    {
        private Long id;
        private LocalDateTime flightDate;
        private String iataCarrierCode;
        private Integer flightNumber;
        private String iataOriginCode;
        private String iataDestinationCode;


        private FlightDTOBuilder()
        {
        }


        public FlightDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public FlightDTOBuilder setFlightDate(LocalDateTime flightDate)
        {
            this.flightDate = flightDate;
            return this;
        }


        public FlightDTOBuilder setIataCarrierCode(String iataCarrierCode)
        {
            this.iataCarrierCode = iataCarrierCode;
            return this;
        }


        public FlightDTOBuilder setFlightNumber(Integer flightNumber)
        {
            this.flightNumber = flightNumber;
            return this;
        }


        public FlightDTOBuilder setIataOriginCode(String iataOriginCode)
        {
            this.iataOriginCode = iataOriginCode;
            return this;
        }


        public FlightDTOBuilder setIataDestinationCode(String iataDestinationCode)
        {
            this.iataDestinationCode = iataDestinationCode;
            return this;
        }


        public FlightDTO createFlightDTO()
        {
            return new FlightDTO(id, flightDate, iataCarrierCode, flightNumber, iataOriginCode, iataDestinationCode);
        }
    }
}
