-- please create data manualy or use JPA Create.java
USE Sample;

SELECT * FROM tblPerson;

SELECT DISTINCT City FROM tblPerson;

SELECT * FROM tblPerson
	WHERE City != 'London';
    
SELECT * FROM tblPerson
	WHERE Age = 20 OR Age = 23 OR Age = 29;

SELECT * FROM tblPerson
	WHERE Age IN(20, 23, 29);
    
SELECT * FROM tblPerson
	WHERE Age BETWEEN 20 AND 25;
    
SELECT * FROM tblPerson
	WHERE City LIKE 'L%';

SELECT * FROM tblPerson
	WHERE Email NOT LIKE '_@_.com';

-- MySQL doesnt have this
SELECT * FROM tblPerson
	WHERE Name LIKE '[^MST]%';
    
SELECT * FROM tblPerson
	WHERE (City = 'London' OR City = 'Mumbai')
	AND Age > 25;

SELECT * FROM tblPerson 
	ORDER BY City ASC, Age DESC;
    
SELECT * FROM tblPerson LIMIT 3;

SELECT Name, Age FROM tblPerson LIMIT 3;

SELECT Name, Age FROM tblPerson LIMIT 2 OFFSET 2;