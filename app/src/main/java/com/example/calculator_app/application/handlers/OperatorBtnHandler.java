package com.example.calculator_app.application.handlers;

import android.view.View;
import android.widget.TextView;

import com.example.calculator_app.presentation.MainActivity;
import com.example.calculator_app.application.Operation;

public class OperatorBtnHandler implements View.OnClickListener {

    private final TextView statusText;
    private final TextView operandText;
    private final Operation operation;
    
    public OperatorBtnHandler(TextView statusText, TextView operandText, Operation operation) {
        this.statusText = statusText;
        this.operandText = operandText;
        this.operation = operation;
    }

    @Override
    public void onClick(View v) {
        if (
            MainActivity.activeOperand.getActive().isInitialized() &&
            MainActivity.activeOperand.getInactive().isInitialized() &&
            MainActivity.operator.getCode() != null
        ) {
            //необходимо посчитать результат, отобразить его в operandText, передать его в операнд1, сделать активным операнд2
            try {
                MainActivity.operator.calc(MainActivity.activeOperand.getActive(), MainActivity.activeOperand.getInactive());

                this.operandText.setText(
                        MainActivity.operator.resultIsInt() ?
                                String.valueOf(MainActivity.operator.getIntResult()) :
                                String.valueOf(MainActivity.operator.getFloatResult())
                );

                MainActivity.activeOperand.clear();
                MainActivity.activeOperand.getActive().clear();
                MainActivity.activeOperand.getInactive().clear();
                if (MainActivity.operator.resultIsInt()) {
                    MainActivity.activeOperand.getActive().setIntValue(MainActivity.operator.getIntResult());
                } else {
                    MainActivity.activeOperand.getActive().setFloatValue(MainActivity.operator.getFloatResult());
                }
                MainActivity.operator.set(this.operation);
                statusText.setText(
                        String.format(
                                "%s %s",
                                MainActivity.activeOperand.getActive().toString(), this.operation.getSign()
                        )
                );
                MainActivity.activeOperand.toggleActive();
            } catch (ArithmeticException e) {
                this.operandText.setText(e.getMessage());
                this.statusText.setText("");
                MainActivity.clearAll();
            }

            return;
        }
        if (!MainActivity.activeOperand.getActive().isInitialized()) {
            MainActivity.activeOperand.getActive().copy(MainActivity.bufferedResult);
        }
        statusText.setText(
            String.format(
                "%s %s",
                MainActivity.activeOperand.getActive().toString(), this.operation.getSign()
            )
        );
        if (MainActivity.operator.getCode() == null) MainActivity.activeOperand.toggleActive();
        MainActivity.operator.set(this.operation);
    }
}
