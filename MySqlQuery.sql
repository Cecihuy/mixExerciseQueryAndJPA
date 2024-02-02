USE Sample;

CREATE TABLE Test1(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Value NVARCHAR(20)
	);

CREATE TABLE Test2(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Value NVARCHAR(20)
	);

INSERT INTO Test1(Value) VALUES('x');

SELECT LAST_INSERT_ID();

INSERT INTO Test1(Value) VALUES('x');

-- same session and the same scope
SELECT LAST_INSERT_ID();

-- same session and accross any scope
SELECT @@IDENTITY;

-- specific table across any session and any scope
SELECT AUTO_INCREMENT
	FROM information_schema.TABLES
	WHERE TABLE_NAME = 'test1';

DELIMITER $$
USE sample$$
CREATE DEFINER = CURRENT_USER TRIGGER trForInsert AFTER INSERT ON test1 FOR EACH ROW
BEGIN
	INSERT INTO Test2(Value)
				VALUES('YYYY');
END$$
DELIMITER ;

INSERT INTO Test1(Value) VALUES('x');

INSERT INTO Test2(Value) VALUES('zzz');