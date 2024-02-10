-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

-- output parameter
DELIMITER //
CREATE PROCEDURE spGetTotalCountOfEmployees1(OUT totalCount INT)
BEGIN
	SELECT COUNT(Id) INTO totalCount
		FROM tblEmployee;
END;

CALL spGetTotalCountOfEmployees1(@bebas);
SELECT @bebas;

-- return values
DELIMITER //
CREATE FUNCTION spGetTotalCountOfEmployees2()
RETURNS INTEGER
DETERMINISTIC
BEGIN
	DECLARE simpan INTEGER;
		SELECT COUNT(Id) INTO simpan FROM tblemployee;
	RETURN simpan;
END;

SELECT spGetTotalCountOfEmployees2();

-- inOut parameter
DELIMITER //
CREATE PROCEDURE spGetNameById1(parId INT, OUT parName VARCHAR(20))
BEGIN
	SELECT Name INTO parName
		FROM tblEmployee
		WHERE Id = parId;
END;

CALL spGetNameById1(1, @bebas);
SELECT @bebas;