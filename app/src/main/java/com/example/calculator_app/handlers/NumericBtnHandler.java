package com.example.calculator_app.handlers;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator_app.MainActivity;
import com.example.calculator_app.Operand;

public class NumericBtnHandler implements View.OnClickListener {

    private final TextView operandText;
    private final TextView statusText;

    public NumericBtnHandler(TextView operandText, TextView statusText) {
        this.operandText = operandText;
        this.statusText = statusText;
    }

    @Override
    public void onClick(View v) {
        if (!MainActivity.activeOperand.getActive().isInitialized()) {
            MainActivity.activeOperand.getActive().init();
        }
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        if (MainActivity.activeOperand.getActive().isInt()) {
            if (MainActivity.activeOperand.getActive().getIntNumSize() < Operand.MAX_NUM_SIZE) {
                MainActivity.activeOperand.getActive().appendToIntValue(buttonText);
                this.operandText.setText(
                    String.valueOf(MainActivity.activeOperand.getActive().getIntValue())
                );
            }
        } else {
            if (MainActivity.activeOperand.getActive().getFloatNumSize() < Operand.MAX_NUM_SIZE) {
                MainActivity.activeOperand.getActive().appendToFloatValue(buttonText);
                this.operandText.setText(
                    String.valueOf(MainActivity.activeOperand.getActive().getFloatValue())
                );
            }
        }

        if (MainActivity.activeOperand.getActive() == MainActivity.operand1)
            this.statusText.setText("");
    }
}
