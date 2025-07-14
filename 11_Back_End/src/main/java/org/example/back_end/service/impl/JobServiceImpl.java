package org.example.back_end.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.entity.Job;
import org.example.back_end.repository.JobRepository;
import org.example.back_end.service.JobService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDTO jobDTO) {
        if(jobDTO.getId()==null){
            throw new IllegalArgumentException("Job Id is null");
        }
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> allJobs=jobRepository.findAll();
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }

    @Override
    public void changeJobStatus(String jobId) {
        jobRepository.updateJobStatus(jobId);
    }

    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
       List<Job> alljobs=jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
       return modelMapper.map(alljobs, new TypeToken<List<JobDTO>>(){}.getType());
    }
}
