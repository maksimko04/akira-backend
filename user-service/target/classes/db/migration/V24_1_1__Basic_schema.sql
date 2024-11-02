CREATE TYPE role_enum AS ENUM ('USER', 'ADMIN', 'SUPER_ADMIN');

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
	login varchar(255) UNIQUE,
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
	avatar varchar(255),
	is_verified boolean,
	role role_enum
);

