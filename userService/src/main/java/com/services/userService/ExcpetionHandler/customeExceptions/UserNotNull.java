package com.services.userService.ExcpetionHandler.customeExceptions;

public class UserNotNull extends RuntimeException {
    public UserNotNull(String message) {
        super(message);
    }
}
