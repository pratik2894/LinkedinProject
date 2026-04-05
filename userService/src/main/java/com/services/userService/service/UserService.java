package com.services.userService.service;

import com.services.userService.ExcpetionHandler.customeExceptions.UserNotFound;
import com.services.userService.ExcpetionHandler.customeExceptions.UserNotNull;
import com.services.userService.Utils.userValidationChecks;
import com.services.userService.configuration.modelMapperConfig;
import com.services.userService.constants.UserEvents;
import com.services.userService.kafkaevents.kafkaUserEvents;
import com.services.userService.models.userModelDto;
import com.services.userService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.services.userService.Entities.userModel;
import org.springframework.ui.ModelMap;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Slf4j
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
                    .eventType(UserEvents.USER_CREATE.toString())
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
 public userModelDto userUpdateEvent(userModelDto userModelDto , UUID userId){
     if(validationChecks.checkUserExistenceOnUserId(userId)){
         if(Objects.isNull(userModelDto)){
             throw new UserNotNull("To update the user, fields cannot be null");
         }else{
             // update the user and send the response
            Optional<userModel> userModel = userRepository.findUserById(userId);
            Optional<userModel> myUpdatedData =  userModel.map( data -> {
                data.setCity(userModelDto.getCity());
                data.setUsername(userModelDto.getUsername());
                data.setFirstName(userModelDto.getFirstName());
                data.setLastName(userModelDto.getLastName());
                data.setEmail(userModelDto.getEmail());
                data.setCountry(userModelDto.getCountry());
                data.setEventType("USER_UPDATE");
                return data;
            });
             kafkaTemplate.send(userTopic,userId,myUpdatedData);
             userModelDto myUserModelDto = modelMapper.map(myUpdatedData , userModelDto.class);
             return myUserModelDto;
         }
     }
     throw new UserNotFound("user not found with this userId : " + userId);
 }

    public userModelDto userDeleteEvent(UUID userId) {
        log.info("User status : " + validationChecks.checkUserExistenceOnUserId(userId) );
        if (validationChecks.checkUserExistenceOnUserId(userId)) {
            Optional<userModel> userModel = userRepository.findUserById(userId);
            Optional<userModel> myDeletedData = userModel.map(data -> {
                data.setEventType("USER_DELETE");
                return data;
            });
            kafkaTemplate.send(userTopic, userId, myDeletedData);
            userModelDto myUserModelDto = modelMapper.map(myDeletedData, userModelDto.class);
            return myUserModelDto;
        }
        throw new UserNotFound("user not found with this userId : " + userId);
    }



}
