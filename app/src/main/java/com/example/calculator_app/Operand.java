package com.example.calculator_app;

import static java.lang.Integer.parseInt;

public class Operand implements Cloneable {
    public static final int MAX_NUM_SIZE = 16;

    private Long intValue = null;
    private Double floatValue = null;
    private boolean isInt = true;

    public Operand() {
    }

    public void copy (Operand parent) {
        this.intValue = parent.isInt() ? parent.getIntValue() : 0L;
        this.floatValue = parent.isInt() ? 0.0d : parent.getFloatValue();
        this.isInt = parent.isInt();
    }

    public void init() {
        this.intValue = 0L;
        this.floatValue = 0.0d;
    }

    public void clear() {
        this.intValue = null;
        this.floatValue = null;
        this.isInt = true;
    }

    public long getIntValue() {
        return this.intValue;
    }

    public double getFloatValue() {
        return this.floatValue;
    }

    public void appendToIntValue(String num) {
        this.intValue = this.intValue * 10 + parseInt(num);
    }

    public void appendToFloatValue(String num) {
        this.floatValue = this.floatValue == 0 ?
            Double.parseDouble(this.intValue + "." + num) :
            Double.parseDouble(this.floatValue + num);
    }

    public void setFloatValue(Double value) {
        this.floatValue = value;
        this.isInt = false;
    }

    public void setIntValue(Long value) {
        this.intValue = value;
        this.isInt = true;
    }

    public void toggleType() {
        this.isInt = !this.isInt;
    }

    public boolean isInt() {
        return isInt;
    }

    public boolean isInitialized() {
        return this.intValue != null || this.floatValue != null;
    }

    public int getIntNumSize() {
        return (int) Math.log10(this.intValue) + 1;
    }

    public int getFloatNumSize() {
        return String.valueOf(this.floatValue).replace(".", "").length();
    }

    @Override
    public String toString() {
        return this.isInt ? String.valueOf(this.intValue) : String.valueOf(this.floatValue);
    }
}
