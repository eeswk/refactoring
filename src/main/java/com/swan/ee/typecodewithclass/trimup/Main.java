package com.swan.ee.typecodewithclass.trimup;

public class Main {
    public static void main(String[] args) {
        Item book = new Item(
                ItemType.BOOK,
                "세계 역사",
                4800
        );
        Item dvd = new Item(
                ItemType.DVD,
                "뉴욕의 꿈 특별판",
                3000
        );
        Item soft = new Item(
                ItemType.SOFTWARE,
                "튜링 머신",
                3200
        );

        System.out.println(book.toString());
        System.out.println(dvd.toString());
        System.out.println(soft.toString());
    }
}
