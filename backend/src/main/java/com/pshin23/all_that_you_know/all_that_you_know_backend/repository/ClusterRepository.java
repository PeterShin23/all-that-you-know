package com.pshin23.all_that_you_know.all_that_you_know_backend.repository;

import com.pshin23.all_that_you_know.all_that_you_know_backend.model.Cluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends JpaRepository<Cluster, Long> {
    boolean existsByName(String name);
}
