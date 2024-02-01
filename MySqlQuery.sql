USE Sample;

CREATE TABLE tblPerson1(
	PersonId INT PRIMARY KEY AUTO_INCREMENT,
	Name NVARCHAR(50));

INSERT INTO tblPerson1(Name) VALUES('John');

INSERT INTO tblPerson1(Name) VALUES('Tom');

INSERT INTO tblPerson1(Name) VALUES('Sara');

DELETE FROM tblPerson1 WHERE PersonId=1;

INSERT INTO tblPerson1(Name) VALUES('Todd');

INSERT INTO tblPerson1(PersonId, Name) VALUES(1, 'Jane');

-- in MySQL doesn't need this
-- SET IDENTITY_INSERT tblPerson1 ON;

-- in MySQL doesn't need this
-- SET IDENTITY_INSERT tblPerson1 OFF;

INSERT INTO tblPerson1(Name) VALUES('Martin');

DELETE FROM tblPerson1;

INSERT INTO tblPerson1(Name) VALUES('Martin');

DELETE FROM tblPerson1;

-- this doesn't work in MySQL
-- DBCC CHECKIDENT(tblPerson1, RESEED, 0);

ALTER TABLE tblperson1
AUTO_INCREMENT = 1 ;

INSERT INTO tblPerson1(Name) VALUES('Martin');