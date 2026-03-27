package com.services.userService.service;

import com.services.userService.configuration.modelMapperConfig;
import com.services.userService.kafkaevents.kafkaUserEvents;
import com.services.userService.models.userModelDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.services.userService.Entities.userModel;
import org.springframework.ui.ModelMap;

import java.util.UUID;


@Service
public class UserService extends kafkaUserEvents {

    @Value("${user.topics.events}")
    private String userTopic;
    private modelMapperConfig modelMapperConfig;
    private final KafkaTemplate kafkaTemplate;
    private ModelMapper modelMapper;

    public UserService(KafkaTemplate kafkaTemplate, ModelMapper modelMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.modelMapper = modelMapper;
    }

    public userModelDto userCreateEvent(userModelDto userModelDto1){
        // convert this model into our entity
        UUID userId = UUID.randomUUID();
        userModel userModel2 = modelMapper.map(userModelDto1, userModel.class);
        userModel userModel3 = userModel2.builder()
                .eventType("USER_CREATE")
                .userId(userId)
                .City(userModelDto1.getCity())
                .Country(userModelDto1.getCountry())
                .firstName(userModelDto1.getFirstName())
                .lastName(userModelDto1.getLastName())
                .username(userModelDto1.getUsername())
                .build();
        kafkaTemplate.send(userTopic,userModel3.getUserId(),userModel3);
        userModelDto myUserModelDto = modelMapper.map(userModel3 , userModelDto.class);
        return myUserModelDto;
    }


}
