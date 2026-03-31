package com.services.dataBaseService.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
public class position {
    private UUID userId;
    private UUID positionId;
    private String title;
    private String employementTypes;
    private String company;
    private Timestamp startDate;
    private Timestamp endDate;
    private String Location;
    private String description;
    private String profileHeadline;
    private String JobFindingSources;
    private List<String> skills;
}
