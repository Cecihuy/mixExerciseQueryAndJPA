-- please create data manualy or use JPA Create.java

SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	LEFT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id
	WHERE tblDepartment.id IS NULL;

SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	RIGHT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id
	WHERE tblEmployee.DepartmentId IS NULL;

SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	FULL JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id
	WHERE tblEmployee.DepartmentId IS NULL
	OR tblDepartment.id IS NULL;