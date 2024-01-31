INSERT INTO tblPerson(ID, Name, Email)
	VALUES(7, 'Rich', 'r@r.com');

--Altering an existing column to add a default constraint
ALTER TABLE tblPerson
	ALTER COLUMN GenderID
	SET DEFAULT 3;

INSERT INTO tblPerson(ID, Name, Email)
	VALUES(8, 'Mike', 'mike@r.com');

INSERT INTO tblPerson(ID, Name, Email, GenderID)
	VALUES(9, 'Sara', 's@r.com', 1);

INSERT INTO tblPerson(ID, Name, Email, GenderID)
	VALUES(10, 'Johnny', 'j@r.com', NULL);

--Adding a new column, with default value, to an existing table
ALTER TABLE {TABLE_NAME}
	ADD {COLUMN_NAME}{DATA_TYPE}{NULL|NOT NULL}
	DEFAULT {DEFAULT_VALUE};

--Dropping a constraint
ALTER TABLE tblPerson
	ALTER COLUMN GenderID
	DROP DEFAULT;