-- please create data manualy or use JPA Create.java
USE Sample;

SELECT*FROM tblEmployee;

SELECT ISNULL(NULL, 'No Manager') AS Manager;

SELECT ISNULL('Pragim', 'No Manager') AS Manager;

SELECT L.Name AS Employee, ISNULL(R.Name, 'No Manager') AS Manager
	FROM tblEmployee L
	LEFT JOIN tblEmployee R
	ON L.ManagerID = R.EmployeeID;

SELECT COALESCE(NULL, 'No Manager') AS Manager;

SELECT COALESCE('Pragim', 'No Manager') AS Manager;

SELECT L.Name AS Employee, COALESCE(R.Name, 'No Manager') AS Manager
	FROM tblEmployee L
	LEFT JOIN tblEmployee R
	ON L.ManagerID = R.EmployeeID;

-- case syntax format
CASE WHEN expression THEN '' ELSE '' END

SELECT L.Name AS Employee, 
	CASE 
		WHEN R.Name IS NULL
		THEN 'No Manager'
		ELSE R.Name
	END
	AS Manager
	FROM tblEmployee L
	LEFT JOIN tblEmployee R
	ON L.ManagerID = R.EmployeeID;