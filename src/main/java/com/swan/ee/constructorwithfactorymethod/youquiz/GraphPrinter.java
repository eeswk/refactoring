package com.swan.ee.constructorwithfactorymethod.youquiz;

public class GraphPrinter extends Printer {
    @Override
    public void println(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.printf(" (%d)", n);
        System.out.println();
    }
}
