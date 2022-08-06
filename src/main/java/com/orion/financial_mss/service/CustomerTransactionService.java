package com.orion.financial_mss.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerTransactionService {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    public BatchStatus persistBatchFile(MultipartFile multipartFile) throws IOException,
            JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        // Create if not exist, file resources folder.
        String path = new ClassPathResource("").getURL().getPath();
        StringBuilder fileDirectorySb = new StringBuilder();
        fileDirectorySb.append(path);
        fileDirectorySb.append("/tmpuploads/");
        File directory = new File(fileDirectorySb.toString());
        if (! directory.exists()){
            directory.mkdir();
        }

        // Saves file into the previously created folder.
        StringBuilder fileImportSb = new StringBuilder();
        fileImportSb.append(directory.toString());
        fileImportSb.append("/");
        fileImportSb.append(multipartFile.getOriginalFilename());
        File fileToImport = new File(fileImportSb.toString());
        OutputStream outputStream = new FileOutputStream(fileToImport);
        IOUtils.copy(multipartFile.getInputStream(), outputStream);
        outputStream.flush();
        outputStream.close();

        // Executes the job.
        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("path",new JobParameter(fileToImport.toString()));
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        // Returns the job status after await the executions
        return jobExecution.getStatus();
    }


}
