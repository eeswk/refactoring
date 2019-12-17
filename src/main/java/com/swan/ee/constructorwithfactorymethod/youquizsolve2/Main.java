package com.swan.ee.constructorwithfactorymethod.youquizsolve2;

public class Main {
    public static void main(String[] args) {
        new Client(new DigitPrinter()).execute();
        new Client(new GraphPrinter()).execute();
    }
}
