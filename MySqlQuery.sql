USE Sample;

ALTER TABLE tblPerson
	ADD CONSTRAINT UQ_tblPerson_Email
	UNIQUE(Email);

INSERT INTO tblPerson(ID, Name, Email, GenderID, Age)
	VALUES(15, 'X', 'a@B.com', 1, 20);

INSERT INTO tblPerson(ID, Name, Email, GenderID, Age)
	VALUES(16, 'XYZ', 'a@B.com', 1, 20);
	
ALTER TABLE tblPerson
	DROP CONSTRAINT UQ_tblPerson_Email;