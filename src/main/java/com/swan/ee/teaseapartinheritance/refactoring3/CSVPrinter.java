package com.swan.ee.teaseapartinheritance.refactoring3;

import java.io.IOException;

public abstract class CSVPrinter {
    protected final CSVReader csvReader;

    public CSVPrinter(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public abstract void print() throws IOException;
}
