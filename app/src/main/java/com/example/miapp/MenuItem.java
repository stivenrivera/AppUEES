package com.example.miapp;

public class MenuItem {
    private String title;
    private int imageResId;

    public MenuItem(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}
