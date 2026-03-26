package com.services.userService.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class ContactInfo {
    private UUID userId;
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID contactId;
    private Integer contactNumber;
    private String address;
    private LocalDate DOB;
    private String webSite;
}
