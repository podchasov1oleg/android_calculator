package com.example.calculator_app.application;

public class Operator {
    private String code = null;
    private String sign = null;
    private long intResult;
    private double floatResult;

    public void set(Operation operation) {
        this.code = operation.getCode();
        this.sign = operation.getSign();
    }

    public String getCode() {
        return code;
    }

    public String getSign() {
        return sign;
    }

    public void calc(Operand operand1, Operand operand2) throws ArithmeticException {
        switch (this.code) {
            case "add":
                if (operand1.isInt() && operand2.isInt()) {
                    this.intResult = operand1.getIntValue() + operand2.getIntValue();
                } else if (operand1.isInt() && !operand2.isInt()) {
                    this.floatResult = operand1.getIntValue() + operand2.getFloatValue();
                } else if (!operand1.isInt() && operand2.isInt()) {
                    this.floatResult = operand1.getFloatValue() + operand2.getIntValue();
                } else {
                    this.floatResult = operand1.getFloatValue() + operand2.getFloatValue();
                }
                break;
            case "sub":
                if (operand1.isInt() && operand2.isInt()) {
                    this.intResult = operand1.getIntValue() - operand2.getIntValue();
                } else if (operand1.isInt() && !operand2.isInt()) {
                    this.floatResult = operand1.getIntValue() - operand2.getFloatValue();
                } else if (!operand1.isInt() && operand2.isInt()) {
                    this.floatResult = operand1.getFloatValue() - operand2.getIntValue();
                } else {
                    this.floatResult = operand1.getFloatValue() - operand2.getFloatValue();
                }
                break;
            case "mul":
                if (operand1.isInt() && operand2.isInt()) {
                    this.intResult = operand1.getIntValue() * operand2.getIntValue();
                } else if (operand1.isInt() && !operand2.isInt()) {
                    this.floatResult = operand1.getIntValue() * operand2.getFloatValue();
                } else if (!operand1.isInt() && operand2.isInt()) {
                    this.floatResult = operand1.getFloatValue() * operand2.getIntValue();
                } else {
                    this.floatResult = operand1.getFloatValue() * operand2.getFloatValue();
                }
                break;
            case "div":
                if (operand2.getIntValue() == 0 && operand2.getFloatValue() == 0)
                    throw new ArithmeticException("Cannot divide by zero");

                if (operand1.isInt() && operand2.isInt()) {
                    this.floatResult = (double) operand1.getIntValue() / (double) operand2.getIntValue();
                } else if (operand1.isInt() && !operand2.isInt()) {
                    this.floatResult = operand1.getIntValue() / operand2.getFloatValue();
                } else if (!operand1.isInt() && operand2.isInt()) {
                    this.floatResult = operand1.getFloatValue() / operand2.getIntValue();
                } else {
                    this.floatResult = operand1.getFloatValue() / operand2.getFloatValue();
                }
                break;
        }

        if (this.floatResult > 0 && this.floatResult % 1 == 0) {
            this.intResult = (long) this.floatResult;
            this.floatResult = 0;
        }
    }

    public void copy(Operator parent) {
        this.code = parent.getCode();
        this.sign = parent.getSign();
    }

    public boolean resultIsInt() {
        return this.intResult != 0;
    }

    public long getIntResult() {
        return intResult;
    }

    public double getFloatResult() {
        return floatResult;
    }

    public void clear() {
        this.code = null;
        this.sign = null;
        this.intResult = 0L;
        this.floatResult = 0.0d;
    }
}
