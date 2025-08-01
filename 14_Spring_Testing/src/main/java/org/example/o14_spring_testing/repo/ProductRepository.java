package org.example.o14_spring_testing.repo;

import org.example.o14_spring_testing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends
        JpaRepository<Product,Long> {
}
