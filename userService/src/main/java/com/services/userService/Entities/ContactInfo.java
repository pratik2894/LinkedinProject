package com.services.userService.Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "contact_info")
public class ContactInfo {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    @Column(unique = true)
    private String Id;
    @ManyToOne
    @JoinColumn(name = "userId") // FK column
    private userModel user;
    private List<Integer> contactNumber;
    private String address;
    private LocalDate DOB;
    private String webSite;
}
