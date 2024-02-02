CREATE TABLE Test1(
	ID INT GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
	Value VARCHAR(20)
	);

CREATE TABLE Test2(
	ID INT GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
	Value VARCHAR(20)
	);

INSERT INTO Test1(Value) VALUES('x');

SELECT lastval();

INSERT INTO Test1 VALUES('x');

-- same session and the same scope
SELECT lastval();

-- same session and accross any scope
SELECT currval('test1_id_seq');

-- specific table across any session and any scope
SELECT MAX(ID) FROM test1;

INSERT INTO Test1 VALUES('x');

INSERT INTO Test2 VALUES('zzz');