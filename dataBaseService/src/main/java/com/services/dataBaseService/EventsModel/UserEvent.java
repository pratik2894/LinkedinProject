package com.services.dataBaseService.EventsModel;

import com.services.dataBaseService.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
@Setter
@Data
public class UserEvent {
    private UUID userId ;
    private String  username;
    private String  firstName;
    private String lastName;
    private String headLine;



}
