package com.swan.ee.teaseapartinheritance.refactoring3;

import java.io.IOException;

public class Main {
    private static final String SAMPLE_CSV_STRING =
        "좋은 아침입니다., Good Morning.\n"
        + "안녕하세요~, Hello.\n"
        + "안녕하세요.,Good evening.\n"
        + "안녕히 주무세요., Good night.\n";

    private static final String SAMPLE_CSV_FILE = "file.csv";


    public static void main(String[] args) throws IOException {
//        new CSVTablePrinter(new CSVStringReader(SAMPLE_CSV_STRING)).print();
//        new CSVTreePrinter(new CSVFileReader(SAMPLE_CSV_FILE)).print();

        new CSVTablePrinter(new CSVFileReader(SAMPLE_CSV_FILE)).print();
        new CSVTreePrinter(new CSVStringReader(SAMPLE_CSV_STRING)).print();
    }
}
