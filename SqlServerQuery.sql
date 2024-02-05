-- please create data manualy or use JPA Create.java
USE Sample;

SELECT SUM(Salary) FROM tblEmployee;

SELECT City, SUM(Salary) AS TotalSalary 
	FROM tblEmployee
	GROUP BY City;

SELECT City, Gender, SUM(Salary) AS TotalSalary 
	FROM tblEmployee
	GROUP BY City, Gender
	ORDER BY City ASC;

SELECT COUNT(ID) FROM tblEmployee;

SELECT City, Gender, SUM(Salary) AS TotalSalary, COUNT(ID) AS [Total Employees]
	FROM tblEmployee
	GROUP BY City, Gender
	ORDER BY City ASC;

SELECT City, Gender, SUM(Salary) AS TotalSalary, COUNT(ID) AS [Total Employees]
	FROM tblEmployee
	GROUP BY City, Gender
	HAVING SUM(Salary) > 5000
	ORDER BY City ASC;