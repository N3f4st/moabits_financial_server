package com.orion.financial_mss.repository;

import com.orion.financial_mss.model.CustomerTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CustomerTransactionRepository extends CrudRepository<CustomerTransaction,Long> {

    final String fn_transactionsByCustomerAndDates = "select id, accountNumber, transactionDate, transactionType, amount, balance from fn_transactionsByCustomerAndDates(:_customer_id, :_fromDate, :_toDate, :_page, :_rows_qty);";
    @Query(value = fn_transactionsByCustomerAndDates, nativeQuery = true)
    List<Map<String, ?>> getTransactionsByCustomerIdAndDates(
            @Param("_customer_id") Long customerId,
            @Param("_fromDate") Date fromDate,
            @Param("_toDate") Date toDate,
            @Param("_page") Long page,
            @Param("_rows_qty") Long rowsQty
    );

    final String rowsQtyByCustomerIdAndDates = "select count (1) from customer_transaction t where t.customer_id = :_customer_id and transaction_date between :_fromDate and :_toDate";
    @Query(value = rowsQtyByCustomerIdAndDates, nativeQuery = true)
    long getRowsQtyByCustomerIdAndDates(@Param("_customer_id") Long customerId,
                                        @Param("_fromDate") Date fromDate,
                                        @Param("_toDate") Date toDate);
}
