package com.example.java.kotlin.java_code.title;

public enum Title {
    JAVA("Java"),
    KOTLIN("Kotlin");

    private final String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
