package com.example.calculator_app.application.handlers;

import android.view.View;
import android.widget.TextView;

import com.example.calculator_app.presentation.MainActivity;

public class ClearAllBtnHandler implements View.OnClickListener {

    private final TextView statusText;
    private final TextView operandText;

    public ClearAllBtnHandler(TextView statusText, TextView operandText) {
        this.statusText = statusText;
        this.operandText = operandText;
    }

    @Override
    public void onClick(View v) {
        statusText.setText("");
        operandText.setText("0");
        MainActivity.clearAll();
    }
}
