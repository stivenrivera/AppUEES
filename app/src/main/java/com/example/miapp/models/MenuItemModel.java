package com.example.miapp.models;

public class MenuItemModel {
    private String title;
    private int imageResId;

    public MenuItemModel(String title, int imageResId) {
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
