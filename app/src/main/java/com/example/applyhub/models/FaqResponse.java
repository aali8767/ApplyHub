package com.example.applyhub.models;

import java.util.List;

public class FaqResponse {
    private boolean status;
    private Message message;
    private List<FaqItem> data;

    public boolean isStatus() {
        return status;
    }

    public Message getMessage() {
        return message;
    }

    public List<FaqItem> getData() {
        return data;
    }

    public static class FaqItem {
        private int id;
        private String title;
        private String description;

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}
