package com.services.dataBaseService.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ContactInfo {
    private UUID userId;
    private UUID contactId;
    private Integer contactNumber;
    private String address;
    private LocalDate DOB;
    private String webSite;
}
