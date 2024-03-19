CREATE TABLE IF NOT EXISTS test_user (
    id      SERIAL NOT NULL,
    name    VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS test_user_seq;