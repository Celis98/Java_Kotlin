package com.example.java.kotlin.title;

public class TitleManager {

    private Title currentTitle;

    public void init() {
        currentTitle = Title.JAVA;
    }

    public void updateTitle() {
        switch (currentTitle) {
            case JAVA:
                currentTitle = Title.KOTLIN;
                break;
            case KOTLIN:
                currentTitle = Title.JAVA;
                break;
        }
    }

    public String getCurrentTitle() {
        return currentTitle.getTitle();
    }
}