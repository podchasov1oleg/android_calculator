package com.example.calculator_app.application.handlers;

import android.content.Intent;
import android.view.View;

import com.example.calculator_app.presentation.MainActivity;
import com.example.calculator_app.presentation.ThemeActivity;

public class ChooseThemeBtnHandler implements View.OnClickListener {

    MainActivity activityContext;

    public ChooseThemeBtnHandler(MainActivity activity) {
        this.activityContext = activity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.activityContext, ThemeActivity.class);
        activityContext.startActivityForResult(intent, MainActivity.LOGIN_REQUEST);
    }
}
