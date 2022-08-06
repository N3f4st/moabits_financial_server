package com.orion.financial_mss.controller;

import com.orion.financial_mss.service.CustomerTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@RestController
@RequestMapping("/customerTransaction")
@RequiredArgsConstructor
public class CustomerTransactionController {

    private final CustomerTransactionService customerTransactionService;

    @PostMapping("/persist-batch-file")
    public BatchStatus persistBatchFile(@RequestParam("file") MultipartFile multipartFile) throws IOException,
            JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        return customerTransactionService.persistBatchFile(multipartFile);
    }

}
