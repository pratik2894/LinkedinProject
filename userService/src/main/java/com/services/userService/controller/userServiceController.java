package com.services.userService.controller;

import com.services.userService.configuration.ApiResponse;
import com.services.userService.configuration.ResponseUtil;
import com.services.userService.models.userModelDto;
import com.services.userService.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class userServiceController {

    private final UserService userService;

    public userServiceController(UserService userService ){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createUser(@Valid @RequestBody userModelDto userModelDto)  {
        try {
            userModelDto userModelDto1 = userService.userCreateEvent(userModelDto);
            if (Objects.isNull(userModelDto1)) {
                log.error("User creation failed, received null response");
                return ResponseEntity.ok(ResponseUtil.error("Issue occurred while creating the user"));
            }
            log.info("User created successfully: {}", userModelDto1);
            return ResponseEntity.ok(ResponseUtil.success("User created successfully", userModelDto1));
        }
        catch (Exception e){
            log.info("-----------------------> Exception occurred while creating the user <---------------------------------- ");
            log.error(e.getLocalizedMessage());
            System.out.println(e);
            return ResponseEntity.ok(ResponseUtil.error(e.getLocalizedMessage()));
        }
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<ApiResponse<?>> createUser(@Valid @RequestBody userModelDto userModelDto , @PathVariable UUID userId)  {
        try {
            userModelDto user =  userService.userUpdateEvent(userModelDto , userId);
            return ResponseEntity.ok(ResponseUtil.success("User updated successfully", user));
        }
        catch (Exception e){
            log.info("-----------------------> Exception occurred while updating  the user <---------------------------------- ");
            log.error(e.getLocalizedMessage());
            System.out.println(e);
            return ResponseEntity.ok(ResponseUtil.error(e.getLocalizedMessage()));
        }
    }
    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<ApiResponse<?>> DeleteUser( @PathVariable UUID userId)  {
        try {
            userModelDto user =  userService.userDeleteEvent(userId);
            return ResponseEntity.ok(ResponseUtil.success("User Delete successfully", user));
        }
        catch (Exception e){
            log.info("-----------------------> Exception occurred while updating  the user <---------------------------------- ");
            log.error(e.getLocalizedMessage());
            System.out.println(e);
            return ResponseEntity.ok(ResponseUtil.error(e.getLocalizedMessage()));
        }
    }

}
