package org.example.back_end.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.service.JobService;
import org.example.back_end.service.impl.JobServiceImpl;
import org.example.back_end.util.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class JobController {
    private final JobService jobService;

    @PostMapping("create")
    public ResponseEntity<APIResponse<String>> createJob(@Valid @RequestBody JobDTO jobDTO) {
        log.info("Job Created Successfully"); // businness logic - informations
        log.debug("Job Details : {}",jobDTO); // details of debugging information
        log.error("Job Creation Failed"); // system error or failers
        log.trace("Job Creation Trace"); // data tracing
        log.warn("Job Creation Warn"); // potential problems

        // save the job
        jobService.saveJob(jobDTO);
        return new ResponseEntity(new APIResponse<>(
                201,
                "Job Created Successfully",
                null
        ), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<APIResponse<String>> updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return ResponseEntity.ok(new APIResponse<>(
                200,
                "Job Updated Successfully",
                null
        ));
    }
    @GetMapping("getalljobs")
    public ResponseEntity<APIResponse<List<JobDTO>>> getAllJobs(){
        List<JobDTO> jobDTOS = jobService.getAllJobs();
        return ResponseEntity.ok(new APIResponse<>(
                200,
                "Job List Fetched Successfully",
                jobDTOS
        ));
    }
    @PatchMapping("status/{id}")
    private ResponseEntity<APIResponse<String>> changeJobStatus(@PathVariable("id") String jobId){
        jobService.changeJobStatus(jobId);
        return ResponseEntity.ok(
                new APIResponse<>(
                        200,
                        "Job Status Changed Successfully",
                        null));
    }
    @GetMapping("search/{keyword}")
    public ResponseEntity<APIResponse<List<JobDTO>>> searchJob(@PathVariable("keyword") String keyword){
        List<JobDTO> jobDTOS = jobService.getAllJobsByKeyword(keyword);
        return ResponseEntity.ok(new APIResponse<>(
                200,
                "Job List Fetched Successfully",
                jobDTOS
        ));
    }
}
