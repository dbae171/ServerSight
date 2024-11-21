package com.danielbae.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerPerformanceDto {
    private Long id;
    private Long employeeId;
    private Double salesAmount;
    private Integer tablesServed;
    private Double feedbackRating;
    private LocalDate performanceDate;
}
