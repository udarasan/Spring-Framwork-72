package org.example.back_end.repository;

import jakarta.transaction.Transactional;
import org.example.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Job SET status='Deactivated' WHERE id =?1"
            ,nativeQuery = true)
    void updateJobStatus(String jobId);

}
