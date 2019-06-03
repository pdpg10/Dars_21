package com.example.dars_21_fragments;

public class Test {
    private int a, b, c;

    public Test(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    static Test createTestWithAC(int a, int c) {
        return new Test(a, 0, c);
    }

    static Test createTestWithAB(int a, int b) {
        return new Test(a, b, 0);
    }

    static Test createTestWithBC(int b, int c) {
        return new Test(0, b, c);
    }

}
