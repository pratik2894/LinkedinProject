package com.services.userService.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_education")
public class Education {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "userId" )
    private userModel user;
    private String degree;
    private String fieldOfStudy;
    private Timestamp startDate;
    private Timestamp endDate;
    private Byte grades;
    private String Description;
    private List<String> skills;
}