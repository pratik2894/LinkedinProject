package com.services.userService.configuration;

import java.util.Map;

public class ResponseException {
    private String status;
    private Map<String , String> Error;

    public String getStatus() {
        return status;
    }

    public ResponseException(String status, Map<String, String> error) {
        this.status = status;
        Error = error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getError() {
        return Error;
    }

    public void setError(Map<String, String> error) {
        Error = error;
    }
}
