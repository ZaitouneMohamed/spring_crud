package com.example.demo.Responses;

public class JsonResponses
{

    private String message;
    private boolean success;

    // Constructor, getters, and setters
    public JsonResponses(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
