package com.example.admin.testingapplication;

public class Calculation {

    int val1, val2;
    Addition a;

    public Calculation(Addition a) {
        this.a = a;
    }

    public int addition() {
        return val1 + val2;
    }

    public int addTen() {
        return a.add( val1, val2) + 10;
    }

    public int subtrction() {
        return val1 - val2;
    }

    public String someString( String x, String y ) {
        return a.additionString( x ) + y;
    }

    public void clear() {
        val1 = 0;
        val2 = 0;
    }

    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
}
