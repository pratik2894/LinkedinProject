package com.services.userService.configuration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Map;


@Getter
@Setter
public class ApiResponse <T>{

    private String status;
    private String message;
    private Map<String , String> validationErrorMessage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getValidationErrorMessage() {
        return validationErrorMessage;
    }

    public void setValidationErrorMessage(Map<String, String> validationErrorMessage) {
        this.validationErrorMessage = validationErrorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    private T data;
    private LocalDateTime timestamp;

    public ApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
    public ApiResponse(String status, String message, Map<String , String> validationErrorMessage) {
        this.status = status;
        this.message = message;
        this.data = null;
        this.validationErrorMessage = validationErrorMessage;
        this.timestamp = LocalDateTime.now();
    }
}
