package com.services.userService.Entities;

import com.services.userService.models.ContactInfo;
import com.services.userService.models.Education;
import com.services.userService.models.position;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String headLine;
    private List<position> positions;
    private String Industry;
    private List<Education> education;
    private String Country;
    private String City;
    private List<ContactInfo> contactInfo;
}
