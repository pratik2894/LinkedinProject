package com.services.userService.models;


import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Data
public class userModelDto {
    private UUID userId;
    @NotBlank(message = "username is required")
    @Length(min = 3, max = 30, message = "name must be 2–300 chars")
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,20}$", message = "invalid username format | correct user name format's are :  user , user_123 , User01 ")
    private String username;
    @NotBlank(message = "first name is required")
    private String firstName;
    @NotBlank(message = "last name is required")
    private String lastName;
    private String headLine;
    private List<position> positions;
    private String Industry;
    private List<Education> education;
    private String Country;
    private String City;
    private List<ContactInfo> contactInfo;
    private String eventType;
    @Email(message = "Provide a valid email")
    @NotBlank(message = "email cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$")
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
