package com.example.applyhub.models;

import java.util.List;

public class ApiResponse {
    private boolean status;
    private Message message;
    private List<Job> data;

    public ApiResponse(boolean status, Message message, List<Job> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List<Job> getData() {
        return data;
    }

    public void setData(List<Job> data) {
        this.data = data;
    }
}
