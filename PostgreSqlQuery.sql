-- please create data manualy or use JPA Create.java

-- postgre doesn't have isnull()
SELECT ISNULL(NULL, 'No Manager') AS Manager;

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