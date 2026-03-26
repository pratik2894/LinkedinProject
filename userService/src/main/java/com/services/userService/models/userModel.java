package com.services.userService.models;


import lombok.Data;
import com.services.userService.models.position;

import java.util.List;
import java.util.UUID;

@Data
public class userModel {
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
