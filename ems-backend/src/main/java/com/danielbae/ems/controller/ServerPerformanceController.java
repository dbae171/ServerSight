package com.danielbae.ems.controller;

import com.danielbae.ems.dto.ServerPerformanceDto;
import com.danielbae.ems.service.ServerPerformanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees/{id}/performance")
public class ServerPerformanceController {

    private final ServerPerformanceService serverPerformanceService;

    @PostMapping
    public ResponseEntity<ServerPerformanceDto> logPerformance(@PathVariable("id") Long employeeId,
                                                               @RequestBody ServerPerformanceDto performanceDto) {
        ServerPerformanceDto savedPerformance = serverPerformanceService.logPerformance(employeeId, performanceDto);
        return new ResponseEntity<>(savedPerformance, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServerPerformanceDto>> getPerformanceByEmployeeId(@PathVariable("id") Long employeeId) {
        List<ServerPerformanceDto> performances = serverPerformanceService.getPerformanceByEmployeeId(employeeId);
        return ResponseEntity.ok(performances);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServerPerformanceDto>> getAllPerformance() {
        List<ServerPerformanceDto> performances = serverPerformanceService.getAllPerformance();
        return ResponseEntity.ok(performances);
    }
}
