package org.example.back_end.service;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.entity.Job;
import org.example.back_end.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public void saveJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setJobTitle(jobDTO.getJobTitle());
        job.setCompany(jobDTO.getCompany());
        job.setType(jobDTO.getType());
        job.setLocation(jobDTO.getLocation());
        jobRepository.save(job);
    }
}
