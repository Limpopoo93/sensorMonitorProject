package com.sensor.monitor.main.db.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usr_role")
@SequenceGenerator(name = "RoleSeq", sequenceName = "seq_usr_role", allocationSize = 1)
public class RoleDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RoleSeq")
    private Long id;

    @Column(name = "name")
    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    private Authority authority;

}
