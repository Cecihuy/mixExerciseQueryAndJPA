USE Sample;

CREATE TABLE tblPerson1(
	PersonId INT PRIMARY KEY IDENTITY(1,1),
	Name NVARCHAR(50));

INSERT INTO tblPerson1 VALUES('John');

INSERT INTO tblPerson1 VALUES('Tom');

INSERT INTO tblPerson1 VALUES('Sara');

DELETE FROM tblPerson1 WHERE PersonId=1;

INSERT INTO tblPerson1 VALUES('Todd');

-- insertion will fail
INSERT INTO tblPerson1 VALUES(1, 'Jane');

SET IDENTITY_INSERT tblPerson1 ON;

INSERT INTO tblPerson1(PersonId, Name) VALUES(1, 'Jane');

SET IDENTITY_INSERT tblPerson1 OFF;

INSERT INTO tblPerson1 VALUES('Martin');

DELETE FROM tblPerson1;

INSERT INTO tblPerson1 VALUES('Martin');

DELETE FROM tblPerson1;

DBCC CHECKIDENT(tblPerson1, RESEED, 0);

INSERT INTO tblPerson1 VALUES('Martin');