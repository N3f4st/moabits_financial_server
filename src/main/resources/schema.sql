
-- validation joins --
ALTER TABLE customer_transaction DROP CONSTRAINT IF EXISTS fk_cust_tran_trans_type;
ALTER TABLE customer_transaction
    ADD CONSTRAINT fk_cust_tran_trans_type
        FOREIGN KEY (transaction_type_id)
            REFERENCES transaction_type (id);
