package com.sensor.monitor.main.db.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "usr_info")
@SequenceGenerator(name = "UserSeq", sequenceName = "seq_usr_user", allocationSize = 1)
public class UserDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "ur.user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> userRoles;

}
