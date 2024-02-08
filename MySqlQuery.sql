-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

DELIMITER //
CREATE PROCEDURE spGetEmployeeCountByGender(IN Gndr VARCHAR(20), OUT EmpCount INT)
BEGIN
	SELECT COUNT(Id) INTO EmpCount
		FROM tblEmployee
		WHERE Gender = Gndr;
END;

CALL spGetEmployeeCountByGender('Male', @bebas);
SELECT @bebas;

SHOW PROCEDURE STATUS WHERE db = 'sample';

SHOW CREATE PROCEDURE spGetEmployeeCountByGender;