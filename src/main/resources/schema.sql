-- create sequence IF NOT EXISTS users_seq start with 1 increment by 50;

-- create table IF NOT EXISTS abc
-- (
--     id
--     bigserial
--     not
--     null,
--     name
--     varchar
-- (
--     255
-- ), primary key
-- (
--     id
-- ))

create table IF NOT EXISTS roles
(
    name varchar
(
    255
) not null unique, primary key
(
    name
));

create table IF NOT EXISTS users
(
    account_non_expired
    boolean
    not
    null,
    account_non_locked
    boolean
    not
    null,
    credentials_non_expired
    boolean
    not
    null,
    enabled
    boolean
    not
    null,
    id
    bigserial
    not
    null,
    email
    varchar
(
    255
), password varchar
(
    255
), username varchar
(
    255
) unique, primary key
(
    id
));


create table IF NOT EXISTS user_roles
(
    user_id
    bigint
    not
    null,
    role_name
    varchar
(
    255
) not null, primary key
(
    user_id,
    role_name
));

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INT REFERENCES "users"
(
    id
),
    role_name VARCHAR REFERENCES roles
(
    name
),
    PRIMARY KEY
(
    user_id,
    role_name
)
    );
