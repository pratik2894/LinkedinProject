package com.services.userService.controller;

import com.services.userService.configuration.ApiResponse;
import com.services.userService.configuration.ResponseUtil;
import com.services.userService.models.userModelDto;
import com.services.userService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class userServiceController {

    private final UserService userService;

    public userServiceController(UserService userService ){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createUser(@RequestBody userModelDto userModelDto) {
        userModelDto userModelDto1 = userService.userCreateEvent(userModelDto);
        if (Objects.isNull(userModelDto1)) {
            log.error("User creation failed, received null response");
            return ResponseEntity.ok(ResponseUtil.error("Issue occurred while creating the user"));
        }
        log.info("User created successfully: {}", userModelDto1);
        return ResponseEntity.ok(ResponseUtil.success("User created successfully", userModelDto1));
    }

}
