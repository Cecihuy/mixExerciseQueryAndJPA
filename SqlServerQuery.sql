USE Sample;

CREATE TABLE Test1(
	ID INT IDENTITY(1,1),
	Value NVARCHAR(20)
	);

CREATE TABLE Test2(
	ID INT IDENTITY(1,1),
	Value NVARCHAR(20)
	);

INSERT INTO Test1 VALUES('x');

SELECT SCOPE_IDENTITY();

INSERT INTO Test1 VALUES('x');

-- same session and the same scope
SELECT SCOPE_IDENTITY();

-- same session and accross any scope
SELECT @@IDENTITY;

-- specific table across any session and any scope
SELECT IDENT_CURRENT('Test1');

CREATE TRIGGER trForInsert
	ON Test1 FOR INSERT	AS
	BEGIN
		INSERT INTO Test2
			VALUES('YYYY')
	END;

INSERT INTO Test1 VALUES('x');

INSERT INTO Test2 VALUES('zzz');