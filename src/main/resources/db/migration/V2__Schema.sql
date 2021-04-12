CREATE TABLE USER
(
    id            BIGINT       NOT NULL
        AUTO_INCREMENT,
    email         VARCHAR(35)  NOT NULL,
    username      VARCHAR(20)  NOT NULL,
    password      VARCHAR(40)  NOT NULL,
    is_enabled    BIT          NOT NULL,
    is_locked     BIT          NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT UNIQUE_USER_USERNAME_EMAIL UNIQUE (email, username)
);

CREATE TABLE AUTHORITY
(
    id             BIGINT      NOT NULL
        AUTO_INCREMENT,
    authority_type VARCHAR(15) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT UNIQUE_AUTHORITY_AUTHORITY_TYPE UNIQUE (authority_type)
);

CREATE TABLE USER_AUTHORITY
(
    user_id      BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,

    PRIMARY KEY (user_id, authority_id),
    CONSTRAINT FOREIGN_KEY_USER_AUTHORITY_USER FOREIGN KEY (user_id) REFERENCES USER (id),
    CONSTRAINT FOREIGN_KEY_USER_AUTHORITY_AUTHORITY FOREIGN KEY (authority_id) REFERENCES AUTHORITY (id)
);
