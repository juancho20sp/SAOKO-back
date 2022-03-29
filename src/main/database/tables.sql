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


-- -----------------------------------------------------
-- Table `DB_TASK`
-- -----------------------------------------------------
CREATE TABLE DB_TASK(
    taskId      SERIAL      PRIMARY KEY,
    taskName    VARCHAR(75) NOT NULL,
    status      VARCHAR(75) NOT NULL,
    roomId      INTEGER NOT NULL,
);

ALTER TABLE DB_TASK
ADD CONSTRAINT CK_TASK_STATUS
CHECK(
	status IN ('TO DO', 'IN PROGRESS', 'DONE')
);

ALTER TABLE DB_TASK ADD CONSTRAINT FK_TASK_ROOM FOREIGN KEY (roomId) REFERENCES DB_ROOM(roomId);




-- -----------------------------------------------------
-- Table `DB_ROOM`
-- -----------------------------------------------------
CREATE TABLE DB_ROOM(
    roomId      SERIAL      PRIMARY KEY,
    roomName    VARCHAR(75) NOT NULL,
    type        VARCHAR(75) NOT NULL,
    userId      INTEGER NOT NULL,
);

ALTER TABLE DB_ROOM ADD CONSTRAINT FK_ROOM_USER FOREIGN KEY (userId) REFERENCES DB_USER(userId);


-- -----------------------------------------------------
-- Table `DB_CHAT`
-- -----------------------------------------------------
CREATE TABLE DB_TASK(
    chatId      SERIAL          PRIMARY KEY,
    message     VARCHAR(140)    NOT NULL,
    roomId      INTEGER         NOT NULL,
);