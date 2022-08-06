package com.orion.financial_mss.batch;

import com.orion.financial_mss.model.CustomerTransaction;
import com.orion.financial_mss.model.TransactionType;
import com.orion.financial_mss.repository.CustomerTransactionRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransactionProcessor implements ItemProcessor<CustomerTransaction, CustomerTransaction> {

    @Autowired
    CustomerTransactionRepository customerTransactionRepository;

@Override
    public CustomerTransaction process(CustomerTransaction customerTransaction) throws Exception {

        if (customerTransaction.getTransactionTypeId() > 3 && customerTransaction.getTransactionTypeId() < 0) throw new Exception();
        return customerTransaction;
    }
}
