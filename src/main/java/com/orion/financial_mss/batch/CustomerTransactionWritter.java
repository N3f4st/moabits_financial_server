package com.orion.financial_mss.batch;

import com.orion.financial_mss.model.CustomerTransaction;
import com.orion.financial_mss.repository.CustomerTransactionRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTransactionWritter implements ItemWriter<CustomerTransaction> {

        @Autowired
        CustomerTransactionRepository customerTransactionRepository;

        @Override
        public void write(List<? extends CustomerTransaction> list) throws Exception {
            customerTransactionRepository.saveAll(list);
            System.out.println("Stored Records: " + list.size());
        }
}

