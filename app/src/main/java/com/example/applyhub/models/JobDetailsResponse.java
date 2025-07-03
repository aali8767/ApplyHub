package com.example.applyhub.models;

public class JobDetailsResponse {
    private boolean status;
    private Message message;
    private Job data;

    public JobDetailsResponse(boolean status, Message message, Job data) {
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

    public Job getData() {
        return data;
    }

    public void setData(Job data) {
        this.data = data;
    }
}
