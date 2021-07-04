package com.airxelerate.challenge.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * This represents a flight.
 */
@Entity
@Table(
    name = "flight",
    uniqueConstraints =
    @UniqueConstraint(columnNames = {"iataCarrierCode", "flightNumber"})
)
public class FlightDO
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Flight date can not be null!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false)
    private LocalDateTime flightDate;

    @NotNull(message = "IATA carrier code can not be null!")
    @Column(nullable = false)
    private String iataCarrierCode;

    @NotNull(message = "Flight number can not be null!")
    @Digits(integer=4, fraction=0)
    @Column(nullable = false)
    private Integer flightNumber;

    @NotNull(message = "IATA origin code can not be null!")
    @Column(nullable = false)
    private String iataOriginCode;

    @NotNull(message = "IATA destination code can not be null!")
    @Column(nullable = false)
    private String iataDestinationCode;


    private FlightDO()
    {
    }


    public FlightDO(LocalDateTime flightDate, String iataCarrierCode, Integer flightNumber, String iataOriginCode, String iataDestinationCode)
    {
        this.flightDate = flightDate;
        this.iataCarrierCode = iataCarrierCode;
        this.flightNumber = flightNumber;
        this.iataOriginCode = iataOriginCode;
        this.iataDestinationCode = iataDestinationCode;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public LocalDateTime getFlightDate()
    {
        return flightDate;
    }


    public void setFlightDate(LocalDateTime flightDate)
    {
        this.flightDate = flightDate;
    }


    public String getIataCarrierCode()
    {
        return iataCarrierCode;
    }


    public void setIataCarrierCode(String iataCarrierCode)
    {
        this.iataCarrierCode = iataCarrierCode;
    }


    public Integer getFlightNumber()
    {
        return flightNumber;
    }


    public void setFlightNumber(Integer flightNumber)
    {
        this.flightNumber = flightNumber;
    }


    public String getIataOriginCode()
    {
        return iataOriginCode;
    }


    public void setIataOriginCode(String iataOriginCode)
    {
        this.iataOriginCode = iataOriginCode;
    }


    public String getIataDestinationCode()
    {
        return iataDestinationCode;
    }


    public void setIataDestinationCode(String iataDestinationCode)
    {
        this.iataDestinationCode = iataDestinationCode;
    }
}
