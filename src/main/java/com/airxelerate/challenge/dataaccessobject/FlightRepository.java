package com.airxelerate.challenge.dataaccessobject;

import com.airxelerate.challenge.domainobject.FlightDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for the flight domain.
 */
@Repository
public interface FlightRepository extends JpaRepository<FlightDO, Long>
{
}
