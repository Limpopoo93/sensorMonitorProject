create table ck_sensor
(
    id          bigserial
        constraint ck_sensor_pk
            primary key,
    name        varchar not null,
    model       varchar not null,
    range_from  integer,
    range_to    integer,
    type        bigint  not null
        constraint ck_type___fk
            references ck_type,
    unit        bigint  not null
        constraint ck_unit___fk
            references ck_unit
            deferrable initially deferred,
    location    varchar,
    description varchar
);

alter table ck_sensor
    owner to postgres;

create table ck_type
(
    id   bigserial
        constraint ck_type_pk
            primary key,
    name varchar not null
);

alter table ck_type
    owner to postgres;

create table ck_unit
(
    id   bigserial
        constraint ck_unit_pk
            primary key,
    name varchar not null
);

alter table ck_unit
    owner to postgres;

create table usr_info
(
    id       bigserial
        constraint usr_info_pk
            primary key,
    login    varchar not null,
    password varchar not null
);

alter table usr_info
    owner to postgres;

create table usr_role
(
    id   bigserial
        constraint usr_role_pk
            primary key,
    name varchar not null
);

alter table usr_role
    owner to postgres;