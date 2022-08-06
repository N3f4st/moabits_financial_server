package com.orion.financial_mss.batch;

import com.orion.financial_mss.model.CustomerTransaction;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CustomerTransactionReader implements ItemReader<CustomerTransaction> {
    @Override
    public CustomerTransaction read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
