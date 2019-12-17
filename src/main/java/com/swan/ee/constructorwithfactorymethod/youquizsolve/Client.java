package com.swan.ee.constructorwithfactorymethod.youquizsolve;

public class Client {
    private final Printer printer;

    public Client(boolean graphical) {
        printer = Printer.create(graphical);
    }

    public void execute() {
        int[] table = {3, 1, 4, 1, 5, 9};
        for ( int n: table) {
            printer.println(n);
        }
    }
}
