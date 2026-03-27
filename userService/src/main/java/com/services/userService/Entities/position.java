package com.services.userService.Entities;

import com.services.userService.constants.EmployementTypes;
import com.services.userService.constants.Sources;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "company_positions")
public class position {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    @Column(unique = true)
    private String Id;

    @ManyToOne
    @JoinColumn(name = "userId"
    )
    private userModel user;
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