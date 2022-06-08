package com.example.covrdesigntest.models;

import android.graphics.drawable.Drawable;

public class DashItem {
    private int bg;
    private int icon;
    private String text;
    private int width;
    private int height;

    public DashItem(int bg, int icon, String text, int width, int height) {
        this.bg = bg;
        this.icon = icon;
        this.text = text;
        this.width = width;
        this.height = height;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
