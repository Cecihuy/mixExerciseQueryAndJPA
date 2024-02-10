-- please create data manualy or use JPA Create.java

SELECT*FROM tblemployee;

CREATE OR REPLACE FUNCTION spGetTotalCountOfEmployees1()
RETURNS NUMERIC AS
$body$
	SELECT COUNT(Id)
		FROM tblEmployee;
$body$
LANGUAGE SQL;

SELECT * FROM spGetTotalCountOfEmployees1();

-- just use pgadmin gui instead query OK!!!
sp_helptext spGetEmployees;