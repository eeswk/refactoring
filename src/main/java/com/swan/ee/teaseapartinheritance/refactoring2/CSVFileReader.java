package com.swan.ee.teaseapartinheritance.refactoring2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileReader extends CSVReader {
    public CSVFileReader(String fileName) throws IOException {
        super(new BufferedReader(new FileReader(fileName)));
    }
}
