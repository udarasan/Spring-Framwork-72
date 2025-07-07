package org.example.back_end.controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.service.JobService;
import org.example.back_end.service.impl.JobServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping("create")
    public String createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return "Job Created";
    }

}
