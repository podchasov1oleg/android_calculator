package com.example.calculator_app.application.handlers;

import android.view.View;
import android.widget.TextView;

import com.example.calculator_app.presentation.MainActivity;

public class DotBtnHandler implements View.OnClickListener {

    private final TextView operandText;

    public DotBtnHandler(TextView operandText) {
        this.operandText = operandText;
    }

    @Override
    public void onClick(View v) {
        if (MainActivity.activeOperand.getActive().isInt()) {
            MainActivity.activeOperand.getActive().toggleType();
            this.operandText.append(".");
        }
    }
}
