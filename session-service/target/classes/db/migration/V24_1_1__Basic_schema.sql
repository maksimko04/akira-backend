CREATE TABLE sessions (
    uid UUID PRIMARY KEY,
    user_id BIGINT NOT NULL,
    last_activity TIMESTAMP NOT NULL,
    ip VARCHAR(50),
    locate VARCHAR(100),
    device VARCHAR(100)
);