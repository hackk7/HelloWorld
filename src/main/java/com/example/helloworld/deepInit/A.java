package com.example.helloworld.deepInit;

public class A {

    public int x;

    public B b;

    public B be = new B();

    public C c;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public B getBe() {
        return be;
    }

    public void setBe(B be) {
        this.be = be;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}