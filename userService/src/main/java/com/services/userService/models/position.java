package com.services.userService.models;

import com.services.userService.constants.EmployementTypes;
import com.services.userService.constants.Sources;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
public class position {
    private UUID userId;
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
