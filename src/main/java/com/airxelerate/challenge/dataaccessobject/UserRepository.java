package com.airxelerate.challenge.dataaccessobject;

import com.airxelerate.challenge.domainobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long>
{
    Optional<UserDO> findByUsername(String username);

    Boolean existsByUsername(String username);
}
