-- -----------------------------------------------------
-- Table `DB_USER`
-- -----------------------------------------------------
CREATE TABLE DB_USER(
    userId      SERIAL          PRIMARY KEY,
    firstName   VARCHAR(75)     NOT NULL,
    lastName    VARCHAR(75)     NOT NULL,
    email       VARCHAR(175)    NOT NULL,
    cell        BIGINT          NULL,
    role        VARCHAR(40)     NOT NULL,
    CONSTRAINT UC_User UNIQUE (email)
);
-- -----------------------------------------------------
-- Table `DB_SALA`
-- -----------------------------------------------------
CREATE TABLE DB_SALA(
    userId      INTEGER         NOT NULL,
    code        VARCHAR(10)     PRIMARY KEY,
    type        VARCHAR(10)     NOT NULL
);