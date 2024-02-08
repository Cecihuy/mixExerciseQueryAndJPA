-- please create data manualy or use JPA Create.java

SELECT*FROM tblemployee;

CREATE OR REPLACE FUNCTION spGetEmployees()
RETURNS SETOF tblemployee AS
$body$
	SELECT * FROM tblemployee;
$body$
LANGUAGE SQL;

SELECT name, gender 
	FROM spgetemployees();
	
CREATE OR REPLACE FUNCTION spGetEmployeesByGenderAndDepartment(Gndr varchar(20), DptId int)
RETURNS SETOF tblemployee AS
$body$
	SELECT *
		FROM tblEmployee
		WHERE Gender = Gndr
		AND DepartmentId = DptId;
$body$
LANGUAGE SQL;

SELECT name, gender, departmentid 
	FROM spGetEmployeesByGenderAndDepartment('Male', 1);

-- just use pgadmin gui instead query OK!!!
sp_helptext spGetEmployees;

DROP FUNCTION spGetEmployees;

-- postgre don't encrypt a function