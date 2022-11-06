package com.sensor.monitor.main.db.domain;

import com.sensor.monitor.main.db.id.UserRoleId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AssociationOverride;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "usr_user_role")
@AssociationOverride(name = "ur.user", joinColumns = @JoinColumn(name = "user_id"))
@AssociationOverride(name = "ur.role", joinColumns = @JoinColumn(name = "role_id"))
public class UserRole implements Serializable {

    @EmbeddedId
    private final UserRoleId ur = new UserRoleId();

    public UserRole(UserDto position, RoleDto role) {
        setUser(position);
        setRole(role);
    }

    @Transient
    public UserDto getUser() {
        return getUr().getUser();
    }

    public void setUser(UserDto user) {
        getUr().setUser(user);
    }

    @Transient
    public RoleDto getRole() {
        return getUr().getRole();
    }

    @Transient
    public Authority getAuthority() {
        return getRole().getAuthority();
    }

    @Transient
    public String getRoleName() {
        return getAuthority().name();
    }

    public void setRole(RoleDto role) {
        getUr().setRole(role);
    }

}
