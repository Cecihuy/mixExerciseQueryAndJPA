-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

SELECT id, COALESCE(FirstName, MiddleName, LastName) AS Name
	FROM tblEmployee;