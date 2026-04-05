package com.services.dataBaseService.kafkaEventListner;

import com.services.dataBaseService.EventsModel.UserEvent;
import com.services.dataBaseService.model.User;
import com.services.dataBaseService.services.UserDbserviceHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListner {

    private final UserDbserviceHandler userDbserviceHandler;

    public UserEventListner(UserDbserviceHandler userDbserviceHandler) {
        this.userDbserviceHandler = userDbserviceHandler;
    }
    @KafkaListener(topics = "user.events", groupId = "user-service-group")
    public void consumeUserEvent(User event) {
        System.out.println("Received Event: " + event);
        processEvent(event);
    }

    public void processEvent(User event) {
        switch (event.getEventType()) {
            case "USER_CREATE":
                userDbserviceHandler.CreateUser(event);
                break;
            case "USER_UPDATE":
                userDbserviceHandler.UpdateUser(event);
                break;
            case "USER_DELETE":
                userDbserviceHandler.removeUser(event);
                break;
        }
    }


}
