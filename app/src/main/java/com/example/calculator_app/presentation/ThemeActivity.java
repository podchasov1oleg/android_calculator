package com.example.calculator_app.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.calculator_app.R;
import com.example.calculator_app.application.ThemeProvider;

public class ThemeActivity extends AppCompatActivity {

    private final ThemeProvider themeProvider = ThemeProvider.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(themeProvider.isDarkTheme() ? R.style.Theme_Calculator_app_Night : R.style.Theme_Calculator_app);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        RadioButton lightBtn = findViewById(R.id.radio_light_theme);
        RadioButton darkBtn = findViewById(R.id.radio_dark_theme);
        Button chooseBtn = findViewById(R.id.choose_theme_button);

        if (themeProvider.isDarkTheme()) {
            darkBtn.setChecked(true);
            //TODO костыль для динамической установки цвета текста у чекбоксов
            darkBtn.setTextColor(Color.WHITE);
            lightBtn.setTextColor(Color.WHITE);
        } else {
            lightBtn.setChecked(true);
            //TODO костыль для динамической установки цвета текста у чекбоксов
            darkBtn.setTextColor(Color.BLACK);
            lightBtn.setTextColor(Color.BLACK);
        }

        lightBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setTheme(R.style.Theme_Calculator_app);
                themeProvider.setDarkTheme(false);
            }
        });
        darkBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setTheme(R.style.Theme_Calculator_app_Night);
                themeProvider.setDarkTheme(true);
            }
        });
        chooseBtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}