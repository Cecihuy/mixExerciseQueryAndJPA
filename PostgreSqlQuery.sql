USE Sample;

CREATE TABLE tblPerson1(
	PersonId INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START 1 INCREMENT 1),
	Name VARCHAR(50));

INSERT INTO tblPerson1(Name) VALUES('John');

INSERT INTO tblPerson1(Name) VALUES('Tom');

INSERT INTO tblPerson1(Name) VALUES('Sara');

DELETE FROM tblPerson1 WHERE PersonId=1;

INSERT INTO tblPerson1(Name) VALUES('Todd');

-- insertion will fail
INSERT INTO tblPerson1(PersonId, Name) VALUES(1, 'Jane');

-- in postgre, no need this
-- SET IDENTITY_INSERT tblPerson1 ON;

INSERT INTO tblPerson1(PersonId, Name) 
	OVERRIDING SYSTEM VALUE
	VALUES(1, 'Jane');
	
-- in postgre, no need this
-- SET IDENTITY_INSERT tblPerson1 OFF;

INSERT INTO tblPerson1(Name) VALUES('Martin');

DELETE FROM tblPerson1;

INSERT INTO tblPerson1(Name) VALUES('Martin');

DELETE FROM tblPerson1;

-- in postgre, this isn't work
-- DBCC CHECKIDENT(tblPerson1, RESEED, 0);

ALTER SEQUENCE tblperson1_personid_seq RESTART;

INSERT INTO tblPerson1(Name) VALUES('Martin');