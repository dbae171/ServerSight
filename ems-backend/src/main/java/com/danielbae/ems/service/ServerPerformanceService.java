package com.danielbae.ems.service;


import com.danielbae.ems.dto.ServerPerformanceDto;

import java.util.List;

public interface ServerPerformanceService {
    ServerPerformanceDto logPerformance(Long employeeId, ServerPerformanceDto performanceDto);
    List<ServerPerformanceDto> getPerformanceByEmployeeId(Long employeeId);
    List<ServerPerformanceDto> getAllPerformance();
}
