package com.example.calculator_app;

public enum Operation {
    ADDITON("add", "+"),
    SUBSTRACTION("sub", "-"),
    MULTIPLICATION("mul", "*"),
    DIVISION("div", "/");

    private final String code;
    private final String sign;

    Operation(String code, String sign) {
        this.code = code;
        this.sign = sign;
    }

    public String getCode() {
        return this.code;
    }

    public String getSign() {
        return sign;
    }

}
