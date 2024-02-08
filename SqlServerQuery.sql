-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

CREATE PROCEDURE spGetEmployees AS
BEGIN
	SELECT Name, Gender
		FROM tblEmployee
END;

spGetEmployees;

EXECUTE spGetEmployees;

CREATE PROCEDURE spGetEmployeesByGenderAndDepartment
@Gndr nvarchar(20),
@DptId int
AS
BEGIN
	SELECT Name, Gender, DepartmentId
		FROM tblEmployee
		WHERE Gender = @Gndr
		AND DepartmentId = @DptId
END;

EXECUTE spGetEmployeesByGenderAndDepartment 'Male', 1;

EXECUTE spGetEmployeesByGenderAndDepartment @DptId=1, @Gndr='Male';

sp_helptext spGetEmployees;

DROP PROCEDURE spGetEmployees;

ALTER PROCEDURE spGetEmployees
WITH ENCRYPTION AS
BEGIN
	SELECT Name, Gender
		FROM tblEmployee
END;