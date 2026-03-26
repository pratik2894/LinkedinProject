package com.services.userService.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Education {
    private UUID userId;
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID educationId;
    private String degree;
    private String fieldOfStudy;
    private Timestamp startDate;
    private Timestamp endDate;
    private Byte grades;
    private String Description;
    private List<String> skills;
}