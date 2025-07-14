package org.example.back_end.controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.service.JobService;
import org.example.back_end.service.impl.JobServiceImpl;
import org.example.back_end.util.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
@CrossOrigin
public class JobController {
    private final JobService jobService;

    @PostMapping("create")
    public String createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return "Job Created";
    }

    @PutMapping("update")
    public String updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return "Job Updated";
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
