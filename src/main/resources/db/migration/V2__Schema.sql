CREATE TABLE USER
(
    id            BIGINT       NOT NULL
        AUTO_INCREMENT PRIMARY KEY,
    email         VARCHAR(35)  NOT NULL,
    username      VARCHAR(20)  NOT NULL,
    password      VARCHAR(40)  NOT NULL,
    is_enabled    BIT          NOT NULL,
    is_locked     BIT          NOT NULL,

    CONSTRAINT UNIQUE_USER_USERNAME_EMAIL UNIQUE (email, username)
);
