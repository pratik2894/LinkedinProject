package com.services.userService.ExcpetionHandler;

import com.services.userService.ExcpetionHandler.customeExceptions.UserAlreadyExistException;
import com.services.userService.configuration.ApiResponse;
import com.services.userService.configuration.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ResponseEntity<ApiResponse<?>> fieldValidation(MethodArgumentNotValidException ex) {
        log.info("-----------------> Error occurred while fields validation <-------------------------------------");
        Map<String , String > errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach( error ->{
         errors.put(error.getField() , error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(new ApiResponse<>("VALIDATION ERROR" , "Error occurred while validating the fields", errors));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public static ResponseEntity<ApiResponse<?>> UserAlreadyExist(UserAlreadyExistException ex) {
        log.info("-----------------> User Already exist with this email <-------------------------------------");
        Map<String , String > errors = new HashMap<>();
        return ResponseEntity.badRequest().body(new ApiResponse<>("VALIDATION ERROR" , ex.getLocalizedMessage(), errors));
    }


}
