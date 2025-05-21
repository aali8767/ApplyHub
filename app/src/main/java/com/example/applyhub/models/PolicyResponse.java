package com.example.applyhub.models;

public class PolicyResponse {
    private boolean status;
    private Message message;
    private Data data;

    public boolean isStatus() {
        return status;
    }

    public Message getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public static class Data {
        private String title;
        private String description;

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}
