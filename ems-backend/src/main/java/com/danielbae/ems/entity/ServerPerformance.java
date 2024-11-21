package com.danielbae.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "server_performance")
public class ServerPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "sales_amount")
    private Double salesAmount;

    @Column(name = "tables_served")
    private Integer tablesServed;

    @Column(name = "feedback_rating")
    private Double feedbackRating;

    @Column(name = "performance_date")
    private LocalDate performanceDate;
}
