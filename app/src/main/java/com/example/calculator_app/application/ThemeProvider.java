package com.example.calculator_app.application;

public class ThemeProvider {

    public static final ThemeProvider INSTANCE = new ThemeProvider();

    private boolean isDarkTheme = false;

    public void setDarkTheme(boolean darkTheme) {
        isDarkTheme = darkTheme;
    }

    public boolean isDarkTheme() {
        return this.isDarkTheme;
    }
}
