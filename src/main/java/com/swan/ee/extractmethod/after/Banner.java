package com.swan.ee.extractmethod.after;

public class Banner {
    private final String content;
    public Banner(String content) {
        this.content = content;
    }

    public void print(int times) {
        //테두리 출력
        printBoarder();
        //내용출력
        printContent(times);
        //테두리출력
        printBoarder();
    }

    private void printBoarder() {
        System.out.print("+");
        for (int i = 0; i < content.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    private void printContent(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("|" + content + "|");
        }
    }

}
