USE Sample;

DELETE FROM tblGender WHERE ID = 2;

ALTER TABLE tblPerson
	DROP CONSTRAINT tblPerson_GenderID_FK;

-- There is no option for MySQL to set default on deletion. use cascade or set null
-- ALTER TABLE tblPerson
-- 	ADD CONSTRAINT tblPerson_GenderID_FK 
-- 	FOREIGN KEY (GenderID)
-- 	REFERENCES tblGender(ID)
-- 	ON DELETE SET DEFAULT;

ALTER TABLE tblperson
ADD CONSTRAINT tblPerson_GenderID_FK
  FOREIGN KEY (GenderID)
  REFERENCES tblgender (ID)
  ON DELETE SET NULL;

DELETE FROM tblGender WHERE ID = 2;

ALTER TABLE tblPerson
	DROP CONSTRAINT tblPerson_GenderID_FK;

ALTER TABLE tblPerson
	ADD CONSTRAINT tblPerson_GenderID_FK 
	FOREIGN KEY (GenderID)
	REFERENCES tblGender(ID)
    ON DELETE CASCADE;

DELETE FROM tblGender WHERE ID = 1;

DELETE FROM tblGender WHERE ID = 3;