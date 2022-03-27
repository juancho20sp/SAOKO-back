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
-- Table `DB_TASK`
-- -----------------------------------------------------
CREATE TABLE DB_TASK(
    taskId      SERIAL      PRIMARY KEY,
    taskName    VARCHAR(75) NOT NULL,
    status      VARCHAR(75) NOT NULL,
    roomId      INTEGER NOT NULL
);

ALTER TABLE DB_TASK
ADD CONSTRAINT CK_TASK_STATUS
CHECK(
	status IN ('TO DO', 'IN PROGRESS', 'DONE')
);

-- -----------------------------------------------------
-- Table `DB_ROOM`
-- -----------------------------------------------------
CREATE TABLE DB_ROOM(
    roomId      SERIAL      PRIMARY KEY,
    roomName    VARCHAR(75) NOT NULL,
    type        VARCHAR(75) NOT NULL,
    userId      INTEGER     NOT NULL
);

ALTER TABLE DB_ROOM
ADD CONSTRAINT CK_ROOM_TYPE
CHECK(
    type IN ('CHAT', 'TASK')
);


