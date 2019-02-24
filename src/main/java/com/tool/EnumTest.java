package com.tool;

public enum EnumTest {
    gao(1),yan(2),xu(5),tian(3){public boolean isRest() {
        return true;
    }};
    private int value;

    private EnumTest(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest() {
        return false;
    }
}
