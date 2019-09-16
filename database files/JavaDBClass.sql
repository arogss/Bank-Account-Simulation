SELECT * FROM transactions; 

SELECT * FROM transactions WHERE customerid = 'customer' ORDER BY ASC;


delete from transactions;

create table transactions (
    time timestamp default systimestamp NOT NULL PRIMARY KEY,
    customerid NVARCHAR2(50),
    operation NVARCHAR2(50),
    amount binary_double,
    balance binary_double
    );

alter table transactions add(
    entry NUMBER GENERATED ALWAYS as IDENTITY(START with 1000 INCREMENT by 1)
    );


    
insert into t1 (c2) values ('hmm');

select * from t1