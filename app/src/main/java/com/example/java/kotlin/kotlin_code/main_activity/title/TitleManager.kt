package com.example.java.kotlin.kotlin_code.main_activity.title

class TitleManager {

    var currentTitle: Title

    init {
        currentTitle = Title.JAVA
    }

    fun updateTitle() {
        currentTitle = when (currentTitle) {
            Title.JAVA -> Title.KOTLIN
            Title.KOTLIN -> Title.JAVA
        }
    }

}