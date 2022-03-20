-- -----------------------------------------------------
-- Table `DB_USER`
-- -----------------------------------------------------
CREATE TABLE DB_USER(
    userId      SERIAL      PRIMARY KEY,
    firstName   VARCHAR(75) NOT NULL,
    lastName    VARCHAR(75) NOT NULL,
    email       VARCHAR(175) NOT NULL,
    role        VARCHAR(40) NOT NULL
);