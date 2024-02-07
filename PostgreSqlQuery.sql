-- please create data manualy or use JPA Create.java
SELECT*FROM tblEmployee;

SELECT L.Name AS Employee, R.Name AS Manager
	FROM tblEmployee L
	LEFT JOIN tblEmployee R
	ON L.ManagerID = R.EmployeeID;