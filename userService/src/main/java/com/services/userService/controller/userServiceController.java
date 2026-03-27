package com.services.userService.controller;

import com.services.userService.models.userModelDto;
import com.services.userService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class userServiceController {

    private final UserService userService;

    public userServiceController(UserService userService) {
        this.userService = userService;
    }

   @PostMapping("/create")
    public ResponseEntity<userModelDto> createUser(@RequestBody userModelDto userModelDto) {
        return ResponseEntity.ok(userService.userCreateEvent(userModelDto));
    }

}
