package com.services.userService.kafkaevents;

import com.services.userService.models.userModelDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public abstract class kafkaUserEvents {

    public userModelDto userCreateEvent(userModelDto userModelDto){return new userModelDto();};
    public void UserDeleted(userModelDto userModelDto){};
    public void UserUpdated(userModelDto userModelDto){};
    public void UserFetch(UUID userId){};

}
