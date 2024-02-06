-- please create data manualy or use JPA Create.java
USE Sample;
    
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

-- use UNION for full join in MySQL
SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	LEFT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id
    WHERE tblDepartment.id IS NULL
UNION
SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	RIGHT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id
    WHERE tblEmployee.DepartmentId IS NULL;
