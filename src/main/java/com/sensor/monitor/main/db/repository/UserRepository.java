package com.sensor.monitor.main.db.repository;

import com.sensor.monitor.main.db.domain.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Long> {

}
