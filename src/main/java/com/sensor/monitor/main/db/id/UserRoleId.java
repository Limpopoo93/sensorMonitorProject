package com.sensor.monitor.main.db.id;

import com.sensor.monitor.main.db.domain.RoleDto;
import com.sensor.monitor.main.db.domain.UserDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Embeddable
@EqualsAndHashCode
public class UserRoleId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private UserDto user;

    @ManyToOne(cascade = CascadeType.ALL)
    private RoleDto role;

}
