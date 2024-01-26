CREATE DATABASE Sample1;
ALTER DATABASE Sample1 MODIFY NAME = Sample2;
sp_renameDB 'Sample2', 'Sample3';
DROP DATABASE Sample3;