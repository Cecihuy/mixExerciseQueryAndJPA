USE Sample;

ALTER TABLE tblPerson
	ADD CONSTRAINT UQ_tblPerson_Email
	UNIQUE(Email);

INSERT INTO tblPerson(ID, Name, Email, GenderID, Age)
	VALUES(4, 'X', 'a@a.com', 1, 20);

INSERT INTO tblPerson(ID, Name, Email, GenderID, Age)
	VALUES(5, 'XYZ', 'a@a.com', 1, 20);
	
ALTER TABLE tblPerson
	DROP CONSTRAINT UQ_tblPerson_Email;