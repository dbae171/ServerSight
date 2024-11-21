package com.danielbae.ems.repository;

import com.danielbae.ems.entity.ServerPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServerPerformanceRepository extends JpaRepository<ServerPerformance, Long> {
    List<ServerPerformance> findByEmployeeId(Long employeeId);
}
