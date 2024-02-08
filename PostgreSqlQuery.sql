-- please create data manualy or use JPA Create.java

SELECT*FROM tblIndiaCustomers
UNION
SELECT*FROM tblKingdomCustomers;

SELECT*FROM tblIndiaCustomers
UNION ALL
SELECT*FROM tblKingdomCustomers
ORDER BY Name DESC;