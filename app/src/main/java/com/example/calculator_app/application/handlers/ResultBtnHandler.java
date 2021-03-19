package com.example.calculator_app.application.handlers;

import android.view.View;
import android.widget.TextView;

import com.example.calculator_app.presentation.MainActivity;

public class ResultBtnHandler implements View.OnClickListener {
    
    private final TextView statusText;
    private final TextView operandText;

    public ResultBtnHandler(TextView statusText, TextView operandText) {
        this.statusText = statusText;
        this.operandText = operandText;
    }

    @Override
    public void onClick(View v) {
        if (!MainActivity.operand2.isInitialized() && !MainActivity.operand1.isInitialized()) {
            try {
                MainActivity.lastOperator.calc(MainActivity.bufferedResult, MainActivity.bufferedOperand2);

                this.statusText.setText(
                    String.format(
                        "%s %s %s = ",
                        MainActivity.bufferedResult.toString(),
                        MainActivity.lastOperator.getSign(),
                        MainActivity.bufferedOperand2.toString()
                    )
                );
                this.operandText.setText(
                    MainActivity.lastOperator.resultIsInt() ?
                        String.valueOf(MainActivity.lastOperator.getIntResult()) :
                        String.valueOf(MainActivity.lastOperator.getFloatResult())
                );

                if (MainActivity.lastOperator.resultIsInt()) {
                    MainActivity.bufferedResult.setIntValue(MainActivity.lastOperator.getIntResult());
                } else {
                    MainActivity.bufferedResult.setFloatValue(MainActivity.lastOperator.getFloatResult());
                }
            } catch (ArithmeticException e) {
                this.operandText.setText(e.getMessage());
                this.statusText.setText("");
                MainActivity.clearAll();
            }
        } else {
            if (!MainActivity.operand2.isInitialized() && MainActivity.operand1.isInitialized()) {
                MainActivity.operand2.copy(MainActivity.operand1);
            }

            try {
                MainActivity.operator.calc(MainActivity.operand1, MainActivity.operand2);

                this.statusText.setText(
                        String.format(
                                "%s %s %s = ",
                                MainActivity.operand1.toString(),
                                MainActivity.operator.getSign(),
                                MainActivity.operand2.toString()
                        )
                );
                this.operandText.setText(
                        MainActivity.operator.resultIsInt() ?
                                String.valueOf(MainActivity.operator.getIntResult()) :
                                String.valueOf(MainActivity.operator.getFloatResult())
                );

                MainActivity.bufferedOperand2.copy(MainActivity.operand2);
                if (MainActivity.operator.resultIsInt()) {
                    MainActivity.bufferedResult.setIntValue(MainActivity.operator.getIntResult());
                } else {
                    MainActivity.bufferedResult.setFloatValue(MainActivity.operator.getFloatResult());
                }
                MainActivity.lastOperator.copy(MainActivity.operator);

                MainActivity.operand1.clear();
                MainActivity.operand2.clear();
                MainActivity.activeOperand.clear();
                MainActivity.operator.clear();
            } catch (ArithmeticException e) {
                this.operandText.setText(e.getMessage());
                this.statusText.setText("");
                MainActivity.clearAll();
            }
        }
    }
}
