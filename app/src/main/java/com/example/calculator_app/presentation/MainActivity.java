package com.example.calculator_app.presentation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator_app.R;
import com.example.calculator_app.application.ActiveOperand;
import com.example.calculator_app.application.Operand;
import com.example.calculator_app.application.Operation;
import com.example.calculator_app.application.Operator;
import com.example.calculator_app.application.handlers.ClearAllBtnHandler;
import com.example.calculator_app.application.handlers.ClearOperandBtnHandler;
import com.example.calculator_app.application.handlers.DotBtnHandler;
import com.example.calculator_app.application.handlers.NumericBtnHandler;
import com.example.calculator_app.application.handlers.OperatorBtnHandler;
import com.example.calculator_app.application.handlers.ResultBtnHandler;

public class MainActivity extends AppCompatActivity {

    public static Operand operand1;
    public static Operand operand2;
    public static Operand bufferedOperand2;
    public static Operand bufferedResult;
    public static ActiveOperand activeOperand;
    public static Operator lastOperator;
    public static Operator operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout gridLayout = findViewById(R.id.grid_container);
        gridLayout.setBackgroundResource(R.drawable.ic_launcher_foreground);

        operand1 = new Operand();
        operand2 = new Operand();
        bufferedOperand2 = new Operand();
        bufferedResult = new Operand();
        activeOperand = new ActiveOperand(operand1, operand2);

        lastOperator = new Operator();
        operator = new Operator();

        TextView operandText = findViewById(R.id.operand_textview);
        TextView statusText = findViewById(R.id.status_textview);

        Button[] numericButtons = new Button[]{
                findViewById(R.id.button_0),
                findViewById(R.id.button_1),
                findViewById(R.id.button_2),
                findViewById(R.id.button_3),
                findViewById(R.id.button_4),
                findViewById(R.id.button_5),
                findViewById(R.id.button_6),
                findViewById(R.id.button_7),
                findViewById(R.id.button_8),
                findViewById(R.id.button_9)
        };

        for (Button button : numericButtons) {
            button.setOnClickListener(new NumericBtnHandler(operandText, statusText));
        }

        Button dotBtn = findViewById(R.id.button_dot);
        dotBtn.setOnClickListener(new DotBtnHandler(operandText));

        Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(new OperatorBtnHandler(statusText, operandText, Operation.ADDITON));

        Button subBtn = findViewById(R.id.button_substract);
        subBtn.setOnClickListener(new OperatorBtnHandler(statusText, operandText, Operation.SUBSTRACTION));

        Button mulBtn = findViewById(R.id.button_multiply);
        mulBtn.setOnClickListener(new OperatorBtnHandler(statusText, operandText, Operation.MULTIPLICATION));

        Button divBtn = findViewById(R.id.button_division);
        divBtn.setOnClickListener(new OperatorBtnHandler(statusText, operandText, Operation.DIVISION));

        Button equalsBtn = findViewById(R.id.button_equals);
        equalsBtn.setOnClickListener(new ResultBtnHandler(statusText, operandText));

        Button clearAllBtn = findViewById(R.id.button_clear_all);
        clearAllBtn.setOnClickListener(new ClearAllBtnHandler(statusText, operandText));

        Button clearOperandBtn = findViewById(R.id.button_clear_operand);
        clearOperandBtn.setOnClickListener(new ClearOperandBtnHandler(operandText));
    }

    public static void clearAll() {
        operand2.clear();
        operand1.clear();
        operand1.init();
        lastOperator.clear();
        operator.clear();
        activeOperand.clear();
    }
}