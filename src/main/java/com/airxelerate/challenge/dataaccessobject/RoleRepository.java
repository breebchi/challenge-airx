package com.airxelerate.challenge.dataaccessobject;

import com.airxelerate.challenge.domainobject.RoleDO;
import com.airxelerate.challenge.domainvalue.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface serves as a repository for the role domain.
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleDO, Long>
{
    Optional<RoleDO> findByName(RoleEnum name);
}
