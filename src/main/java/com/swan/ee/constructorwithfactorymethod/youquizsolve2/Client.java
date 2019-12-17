package com.swan.ee.constructorwithfactorymethod.youquizsolve2;

public class Client {

    private final Printer printer;

    public Client(Printer printer) {
        this.printer = printer;
    }

    public void execute() {
        int[] table = {3, 1, 4, 1, 5, 9};
        for ( int n: table) {
            printer.println(n);
        }
    }
}
