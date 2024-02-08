-- please create data manualy or use JPA Create.java

SELECT*FROM tblemployee;

CREATE OR REPLACE FUNCTION spGetEmployeeCountByGender(Gndr varchar(20))
RETURNS NUMERIC AS
$body$
	SELECT COUNT(Id)
		FROM tblEmployee
		WHERE Gender = Gndr;
$body$
LANGUAGE SQL;

SELECT spGetEmployeeCountByGender('Male');

-- just use pgadmin gui instead query OK!!!
sp_helptext spGetEmployees;