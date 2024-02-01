ALTER TABLE tblPerson
	ADD Age INT NULL;

-- drop check constraint if exist
ALTER TABLE tblPerson
	DROP CONSTRAINT CK_tblPerson_Age;

-- create check constraint
ALTER TABLE tblPerson
	ADD CONSTRAINT CK_tblPerson_Age
	CHECK(Age > 0 AND Age < 150);

-- insertion will fail
INSERT INTO tblPerson(ID, Name, Email, Age)
	VALUES(11, 'Chuck', 'c@c.com', 200);

INSERT INTO tblPerson(ID, Name, Email, Age)
	VALUES(11, 'Chuck', 'c@c.com', 25);

INSERT INTO tblPerson(ID, Name, Email, Age)
	VALUES(12, 'Chuck', 'c@c.com', NULL);