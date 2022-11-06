package com.sensor.monitor.main.db.repository;

import com.sensor.monitor.main.db.domain.Authority;
import com.sensor.monitor.main.db.domain.RoleDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleDto, Long> {

    RoleDto getRoleDtoByAuthority(Authority authority);

}
