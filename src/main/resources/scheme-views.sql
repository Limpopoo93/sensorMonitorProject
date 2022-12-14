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

-- User table --
create table usr_info
(
    id       bigint not null
        constraint usr_info_pk
            primary key,
    login    varchar not null,
    password varchar not null
);

alter table usr_info
    owner to postgres;

-- Role table --
create table usr_role
(
    id   bigint
        constraint usr_role_pk
            primary key,
    name varchar not null
        constraint check_role_name
            check (upper((name)::text) = ANY
                   (ARRAY['ADMINISTRATOR'::text, 'VIEWER'::text]))
);

alter table usr_role
    owner to postgres;

create unique index ix_fx_role_name
    on usr_role (name);

-- User_Role table --
create table usr_user_role
(
    user_id bigint not null
        constraint fk_user
            references usr_info,
    role_id bigint not null
        constraint fk_role
            references usr_role
);

alter table usr_user_role
    owner to postgres;