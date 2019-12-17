package com.swan.ee.teaseapartinheritance.refactoring2;

import java.io.IOException;

public abstract class CSVPrinter {
    protected final CSVReader csvReader;

    public CSVPrinter(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public abstract String[] readCSV() throws IOException;
    public abstract void print() throws IOException;
}
