package com.danielbae.ems.mapper;

import com.danielbae.ems.dto.ServerPerformanceDto;
import com.danielbae.ems.entity.ServerPerformance;

public class ServerPerformanceMapper {

    public static ServerPerformanceDto mapToServerPerformanceDto(ServerPerformance performance) { // Changed method name
        return new ServerPerformanceDto(
                performance.getId(),
                performance.getEmployee().getId(),
                performance.getSalesAmount(),
                performance.getTablesServed(),
                performance.getFeedbackRating(),
                performance.getPerformanceDate()
        );
    }

    public static ServerPerformance mapToServerPerformance(ServerPerformanceDto performanceDto) {
        ServerPerformance performance = new ServerPerformance();
        performance.setSalesAmount(performanceDto.getSalesAmount());
        performance.setTablesServed(performanceDto.getTablesServed());
        performance.setFeedbackRating(performanceDto.getFeedbackRating());
        performance.setPerformanceDate(performanceDto.getPerformanceDate());

        return performance;
    }
}
