package com.swan.ee.teaseapartinheritance.refactoring3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class CSVStringReader extends CSVReader {
    public CSVStringReader(String string) throws IOException {
        super(new BufferedReader(new StringReader(string)));
    }

}
