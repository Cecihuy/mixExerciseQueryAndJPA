-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

-- output parameter
CREATE PROCEDURE spGetTotalCountOfEmployees1
@TotalCount INT OUTPUT
AS
BEGIN
	SELECT @TotalCount = COUNT(Id)
		FROM tblEmployee
END;

DECLARE @Total INT
EXECUTE spGetTotalCountOfEmployees1 @Total OUTPUT
PRINT @Total;

-- return values
CREATE PROCEDURE spGetTotalCountOfEmployees2
AS
BEGIN
	RETURN(SELECT COUNT(Id) FROM tblEmployee)
END;

DECLARE @Total INT
EXECUTE @Total = spGetTotalCountOfEmployees2
PRINT @Total;

-- inOut parameter
CREATE PROCEDURE spGetNameById1
@ParId INT,
@ParName NVARCHAR(20) OUTPUT
AS
BEGIN
	SELECT @ParName = Name
		FROM tblEmployee
		WHERE Id = @ParId
END;

DECLARE @VarName NVARCHAR(20)
EXECUTE spGetNameById1 1, @VarName OUTPUT
PRINT 'Name = ' + @VarName;

-- return value with input
CREATE PROCEDURE spGetNameById2
@ParId INT
AS
BEGIN
	RETURN(
		SELECT Name	FROM tblEmployee
		WHERE Id = @ParId
	)
END;

-- will fail because returns String.
-- 'Return value' will always returns Integer and
-- only single return value
DECLARE @VarName NVARCHAR(20)
EXECUTE @VarName = spGetNameById2 1
PRINT 'Name = ' + @VarName;