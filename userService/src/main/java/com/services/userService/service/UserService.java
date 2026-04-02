package com.services.userService.service;

import com.services.userService.Utils.userValidationChecks;
import com.services.userService.configuration.modelMapperConfig;
import com.services.userService.kafkaevents.kafkaUserEvents;
import com.services.userService.models.userModelDto;
import com.services.userService.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final userValidationChecks validationChecks;

    public UserService(KafkaTemplate kafkaTemplate, ModelMapper modelMapper, UserRepository userRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.validationChecks = new userValidationChecks(this.userRepository);
    }

    public userModelDto userCreateEvent(userModelDto userModelDto1){
        // convert this model into our entity
        if(!validationChecks.checkUserExistence(userModelDto1.getEmail())){
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
                    .email(userModelDto1.getEmail())
                    .build();
            kafkaTemplate.send(userTopic,userModel3.getUserId(),userModel3);
            userModelDto myUserModelDto = modelMapper.map(userModel3 , userModelDto.class);
            return myUserModelDto;
        }
        return null;
    }

}
