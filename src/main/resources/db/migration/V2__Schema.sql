CREATE TABLE USER
(
    id            BIGINT       NOT NULL
        AUTO_INCREMENT,
    email         VARCHAR(35)  NOT NULL,
    username      VARCHAR(20)  NOT NULL,
    password      VARCHAR(60)  NOT NULL,
    is_enabled    BIT          NOT NULL,
    is_locked     BIT          NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT UNIQUE_USER_USERNAME_EMAIL UNIQUE (email, username)
);

CREATE TABLE TOKEN
(
    user_id BIGINT      NOT NULL,
    value   VARCHAR(40) NOT NULL,

    PRIMARY KEY (user_id),
    CONSTRAINT UNIQUE_VALUE UNIQUE (value),
    CONSTRAINT FOREIGN_KEY_TOKEN_USER FOREIGN KEY (user_id) REFERENCES USER (id) ON DELETE CASCADE
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

CREATE TABLE PERSON
(
    user_id       BIGINT      NOT NULL,
    first_name    VARCHAR(20) NOT NULL,
    last_name     VARCHAR(30),
    birth_place   VARCHAR(40),
    date_of_birth DATE,
    date_of_death DATE,

    PRIMARY KEY (user_id),
    CONSTRAINT FOREIGN_KEY_PERSON_USER FOREIGN KEY (user_id) REFERENCES USER (id) ON DELETE CASCADE
);

CREATE TABLE PRODUCTION
(
    id           BIGINT       NOT NULL
        AUTO_INCREMENT,
    name         VARCHAR(50)  NOT NULL,
    description  VARCHAR(500),
    release_date DATE         NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE FILM
(
    production_id BIGINT NOT NULL,
    direction     VARCHAR(30),
    scenario      VARCHAR(30),

    PRIMARY KEY (production_id),
    CONSTRAINT FOREIGN_KEY_FILM_PRODUCTION FOREIGN KEY (production_id) REFERENCES PRODUCTION (id)
);

CREATE TABLE SERIES
(
    production_id BIGINT NOT NULL,
    creator       VARCHAR(40),

    PRIMARY KEY (production_id),
    CONSTRAINT FOREIGN_KEY_SERIES_PRODUCTION FOREIGN KEY (production_id) REFERENCES PRODUCTION (id)
);
