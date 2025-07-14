package org.example.back_end.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.entity.Job;
import org.example.back_end.exceptions.ResourceNotFound;
import org.example.back_end.repository.JobRepository;
import org.example.back_end.service.JobService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDTO jobDTO) {
        if (jobDTO==null){
            log.error("JobDTO cannot be null");
            throw new IllegalArgumentException("JobDTO cannot be null");
        }
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        if (jobDTO==null||jobDTO.getId()==null){
            throw new IllegalArgumentException("Job Id cannot be null");
        }
        jobRepository.findById(jobDTO.getId()).orElseThrow(
                ()->new ResourceNotFound("Job Not Found"));
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> allJobs=jobRepository.findAll();
        if (allJobs.isEmpty()){
            throw new ResourceNotFound("No Job Found");
        }
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }

    @Override
    public void changeJobStatus(String jobId) {
        if (jobId==null){
            throw new IllegalArgumentException("Job Id cannot be null");
        }
        jobRepository.updateJobStatus(jobId);
    }

    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        if (keyword==null){
            throw new IllegalArgumentException("Keyword cannot be null");
        }
       List<Job> alljobs=jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
       if (alljobs.isEmpty()){
           throw new ResourceNotFound("No Job Found");
       }
       return modelMapper.map(alljobs, new TypeToken<List<JobDTO>>(){}.getType());
    }
}
