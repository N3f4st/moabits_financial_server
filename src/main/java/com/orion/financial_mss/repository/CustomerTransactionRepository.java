package com.orion.financial_mss.repository;

import com.orion.financial_mss.model.CustomerTransaction;
import org.springframework.data.repository.CrudRepository;

public interface CustomerTransactionRepository extends CrudRepository<CustomerTransaction,Long> {

}
