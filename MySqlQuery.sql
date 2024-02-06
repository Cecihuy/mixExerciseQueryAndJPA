-- please create data manualy or use JPA Create.java
USE Sample;

SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	INNER JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id;
    
SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	LEFT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id;

SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	RIGHT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id;

-- use UNION for full join in MySQL
SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	LEFT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id
UNION
SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	RIGHT JOIN tblDepartment
	ON tblEmployee.DepartmentId = tblDepartment.id;

SELECT Name, Gender, Salary, DepartmentName
	FROM tblEmployee
	CROSS JOIN tblDepartment;