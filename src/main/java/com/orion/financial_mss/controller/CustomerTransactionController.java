package com.orion.financial_mss.controller;

import com.orion.financial_mss.service.CustomerTransactionService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@RestController
@RequestMapping("/customerTransaction")
public class CustomerTransactionController {

    private final CustomerTransactionService customerTransactionService;
    @Autowired
    public CustomerTransactionController(CustomerTransactionService customerTransactionService){
        this.customerTransactionService = customerTransactionService;
    }

    @PostMapping("/persist-batch-file")
    public BatchStatus persistBatchFile(@RequestParam("file") MultipartFile multipartFile) throws IOException,
            JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        return customerTransactionService.persistBatchFile(multipartFile);
    }

}
