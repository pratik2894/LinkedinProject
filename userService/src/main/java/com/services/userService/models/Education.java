package com.services.userService.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
public class Education {
    private UUID userId;
    private UUID educationId;
    private String degree;
    private String fieldOfStudy;
    private Timestamp startDate;
    private Timestamp endDate;
    private Byte grades;
    private String Description;
    private List<String> skills;
}
