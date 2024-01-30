CREATE DATABASE Sample;

CREATE TABLE tblPerson(
	ID INT PRIMARY KEY NOT NULL,
	Name VARCHAR(50) NOT NULL,
	Email VARCHAR(50) NOT NULL,
	GenderID INT
	);

CREATE TABLE tblGender(
	ID INT NOT NULL PRIMARY KEY,
	Gender VARCHAR(50) NOT NULL
	);

INSERT INTO tblGender VALUES
	(1, 'Male'),
	(2, 'Female'),
	(3, 'Unknown');

ALTER TABLE tblPerson
	ADD CONSTRAINT tblPerson_GenderID_FK
	FOREIGN KEY(GenderID)
	REFERENCES tblGender(ID);

INSERT INTO tblPerson VALUES
	(1, 'John', 'j@j.com', 1),
	(2, 'Mary', 'm@m.com', 2),
	(3, 'Simon', 's@s.com', 1),
	(4, 'Sam', 'sam@sam.com', 1),
	(5, 'May', 'may@may.com', 2),
	(6, 'Kenny', 'k@k.com', 3);