package com.services.userService.Entities;

import com.services.userService.Entities.ContactInfo;
import com.services.userService.Entities.Education;
import com.services.userService.Entities.position;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_table")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String headLine;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<position> positions;
    private String Industry;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Education> education;
    private String Country;
    private String City;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<ContactInfo> contactInfo;
    private String eventType;
}
