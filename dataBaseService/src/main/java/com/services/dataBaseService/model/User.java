package com.services.dataBaseService.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Data
@Getter
@Setter
public class User {

    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String headLine;
    private List<position> positions;
    private String industry;
    private List<Education> education;
    private String country;
    private String city;
    private List<ContactInfo> contactInfo;
    private String eventType;
    private String email;
}
