package com.services.userService.Utils;

import com.services.userService.ExcpetionHandler.customeExceptions.UserAlreadyExistException;
import com.services.userService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class userValidationChecks {

    public userValidationChecks(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository ;

    public boolean checkUserExistence(String email){
        log.info("This is user validation : " + userRepository.existsByEmail(email));
        if(userRepository.existsByEmail(email)){
            throw new UserAlreadyExistException("User with email : " + email + " Already exists");
        }
        return false;
    }

}
