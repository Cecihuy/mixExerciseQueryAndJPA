-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

CREATE PROCEDURE spGetEmployeeCountByGender
@Gndr NVARCHAR(20),
@EmpCount INT OUTPUT
AS
BEGIN
	SELECT @EmpCount = COUNT(Id) 
		FROM tblEmployee
		WHERE Gender = @Gndr
END;

DECLARE @TotalCount INT
EXECUTE spGetEmployeeCountByGender @Gndr='Male', @EmpCount=@TotalCount OUTPUT
PRINT @TotalCount;

sp_depends spGetEmployeeCountByGender;

sp_depends tblEmployee;