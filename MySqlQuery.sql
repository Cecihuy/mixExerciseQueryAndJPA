-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

DELIMITER //
CREATE PROCEDURE spGetEmployees()
BEGIN
	SELECT Name, Gender
		FROM tblEmployee;
END;

CALL spGetEmployees;

DELIMITER //
CREATE PROCEDURE spGetEmployeesByGenderAndDepartment(Gndr varchar(20), DptId int)
BEGIN
	SELECT Name, Gender, DepartmentId
		FROM tblEmployee
		WHERE Gender = Gndr
		AND DepartmentId = DptId;
END;

CALL spGetEmployeesByGenderAndDepartment ('Male', 1);

SHOW CREATE PROCEDURE spGetEmployees;

DROP PROCEDURE spGetEmployees;

-- MySQL not do encryption in procedure