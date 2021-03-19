package com.example.calculator_app.application;

public class ActiveOperand {
    Operand operand1;
    Operand operand2;
    Operand active;

    public ActiveOperand(Operand operand1, Operand operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.active = operand1;
    }

    public void toggleActive() {
        this.active = this.active == this.operand1 ? this.operand2 : this.operand1;
    }

    public Operand getActive() {
        return this.active;
    }

    public Operand getInactive() {
        return this.active == this.operand1 ? this.operand2 : this.operand1;
    }

    public void clear() {
        this.active = operand1;
    }
}
