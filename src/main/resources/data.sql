-- Necessary catalog data.
INSERT INTO transaction_type (id, name)
select 1, 'Debit' where not exists (select id from transaction_type where id = 1);

INSERT INTO transaction_type (id, name)
select 2, 'Credit' where not exists (select id from transaction_type where id = 2);

INSERT INTO transaction_type (id, name)
select 3, 'Transaction' where not exists (select id from transaction_type where id = 3);

