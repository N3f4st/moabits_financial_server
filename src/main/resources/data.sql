-- Necessary catalog data.
-- Transaction types
INSERT INTO transaction_type (id, name)
select 1, 'Debit' where not exists (select id from transaction_type where id = 1);

INSERT INTO transaction_type (id, name)
select 2, 'Credit' where not exists (select id from transaction_type where id = 2);

INSERT INTO transaction_type (id, name)
select 3, 'Transaction' where not exists (select id from transaction_type where id = 3);

-- Customers
insert into customer (id, credit_limit, full_name, short_name) select 1, 295832, 'Banco de Finanzas', 'BDF' where not exists (select id from customer where id = 1);
insert into customer (id, credit_limit, full_name, short_name) select 2, 1890243, 'Banco de Fomento a la Producción', 'BFP' where not exists (select id from customer where id = 2);
insert into customer (id, credit_limit, full_name, short_name) select 3, 448923, 'Banco de América Central', 'BAC' where not exists (select id from customer where id = 3);

-- appUsers
insert into app_user (id, full_name, password, user_name)
SELECT 1, 'TestingPurposesUser', '2!"3NHK89FMKN4%$', 'jurg' WHERE NOT exists(select id from app_user where id = 1 );

