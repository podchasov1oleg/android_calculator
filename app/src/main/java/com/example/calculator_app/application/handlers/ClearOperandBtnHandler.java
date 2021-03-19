package com.example.calculator_app.application.handlers;

import android.view.View;
import android.widget.TextView;

import com.example.calculator_app.presentation.MainActivity;

public class ClearOperandBtnHandler implements View.OnClickListener {

    private final TextView operandText;

    public ClearOperandBtnHandler(TextView operandText) {
        this.operandText = operandText;
    }

    @Override
    public void onClick(View v) {
        operandText.setText("0");
        MainActivity.activeOperand.getActive().clear();
        MainActivity.activeOperand.getActive().init();
    }
}
