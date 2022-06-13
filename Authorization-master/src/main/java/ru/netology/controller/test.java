package ru.netology.controller;

import java.util.Objects;

public class test {
    int a;
    String b;

    public test(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        test test = (test) o;
        return a == test.a && Objects.equals(b, test.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
