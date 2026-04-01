package com.services.userService.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class userModelDto {
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
    private String eventType;
    private String email;

    @Override
    public String toString() {
        return "userModelDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", headLine='" + headLine + '\'' +
                ", positions=" + positions +
                ", Industry='" + Industry + '\'' +
                ", education=" + education +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", contactInfo=" + contactInfo +
                ", eventType='" + eventType + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
