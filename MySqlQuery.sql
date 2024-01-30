create database sample;

use sample;

create table tblperson(
	ID int primary key not null,
	Name nvarchar(50) not null,
	Email nvarchar(50) not null,
	GenderID int
	);

create table tblgender(
	ID int not null primary key,
	Gender nvarchar(50) not null
	);

insert into tblgender values
	(1, 'Male'),
	(2, 'Female'),
	(3, 'Unknown');

alter table tblperson
	add constraint tblPerson_GenderID_FK
	foreign key(GenderID)
	references tblgender(ID);

insert into tblperson values
	(1, 'John', 'j@j.com', 1),
	(2, 'Mary', 'm@m.com', 2),
	(3, 'Simon', 's@s.com', 1),
	(4, 'Sam', 'sam@sam.com', 1),
	(5, 'May', 'may@may.com', 2),
	(6, 'Kenny', 'k@k.com', 3);