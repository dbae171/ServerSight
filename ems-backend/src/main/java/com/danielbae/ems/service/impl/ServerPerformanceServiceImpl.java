package com.danielbae.ems.service.impl;

import com.danielbae.ems.dto.ServerPerformanceDto;
import com.danielbae.ems.entity.Employee;
import com.danielbae.ems.entity.ServerPerformance;
import com.danielbae.ems.exception.ResourceNotFoundException;
import com.danielbae.ems.mapper.ServerPerformanceMapper;
import com.danielbae.ems.repository.EmployeeRepository;
import com.danielbae.ems.repository.ServerPerformanceRepository;
import com.danielbae.ems.service.ServerPerformanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServerPerformanceServiceImpl implements ServerPerformanceService {

    private final ServerPerformanceRepository serverPerformanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public ServerPerformanceDto logPerformance(Long employeeId, ServerPerformanceDto performanceDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

        ServerPerformance performance = ServerPerformanceMapper.mapToServerPerformance(performanceDto);
        performance.setEmployee(employee);
        ServerPerformance savedPerformance = serverPerformanceRepository.save(performance);

        return ServerPerformanceMapper.mapToServerPerformanceDto(savedPerformance);
    }

    @Override
    public List<ServerPerformanceDto> getPerformanceByEmployeeId(Long employeeId) {
        List<ServerPerformance> performances = serverPerformanceRepository.findByEmployeeId(employeeId);
        return performances.stream()
                .map(ServerPerformanceMapper::mapToServerPerformanceDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ServerPerformanceDto> getAllPerformance() {
        List<ServerPerformance> performances = serverPerformanceRepository.findAll();
        return performances.stream()
                .map(ServerPerformanceMapper::mapToServerPerformanceDto)
                .collect(Collectors.toList());
    }
}
