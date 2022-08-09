-- database objects and structure
-- validation joins --
ALTER TABLE customer_transaction DROP CONSTRAINT IF EXISTS fk_cust_tran_trans_type;
ALTER TABLE customer_transaction
    ADD CONSTRAINT fk_cust_tran_trans_type
        FOREIGN KEY (transaction_type_id)
            REFERENCES transaction_type (id);

-- function to retrieve transactions with its balances with some parammeters
create or replace function fn_transactionsByCustomerAndDates(_customer_id bigint, _fromDate date, _toDate date, _page bigint, _rows_qty bigint)
    returns table (id bigint, accountNumber bigint, transactionDate date, transactionType text, amount numeric(18,8), balance numeric(18,8))
as
'
    SELECT t.id, t.account_number, t.transaction_date, tt.name as transactionType, t.amount
         , SUM(CASE WHEN t.transaction_type_id = 1 THEN -t.amount
                    WHEN t.transaction_type_id = 2 THEN t.amount
        END) OVER (ORDER BY t.transaction_date, t.id)::numeric(18,8) as balance
    FROM customer_transaction t
             INNER JOIN transaction_type tt on t.transaction_type_id = tt.id
    WHERE t.customer_id = _customer_id and transaction_date between _fromDate and _toDate
    ORDER BY t.transaction_date, t.id asc
        offset _page limit _rows_qty ;
'
    language sql;
