package com.services.userService.ExcpetionHandler.customeExceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
