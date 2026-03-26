package com.services.userService.Entities;

import com.services.userService.constants.EmployementTypes;
import com.services.userService.constants.Sources;
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
public class position {
    private UUID userId;
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID positionId;
    private String title;
    private EmployementTypes employementTypes;
    private String company;
    private Timestamp startDate;
    private Timestamp endDate;
    private String Location;
    private String description;
    private String profileHeadline;
    private Sources JobFindingSources;
    private List<String> skills;

}