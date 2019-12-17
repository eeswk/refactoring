package com.swan.ee.typecodewithclass.before;

public class Main {
    public static void main(String[] args) {
        Item book = new Item(
                Item.TYPECODE_BOOK,
                "세계 역사",
                4800
        );
        Item dvd = new Item(
                Item.TYPECODE_DVD,
                "뉴욕의 꿈 특별판",
                3000
        );
        Item soft = new Item(
                Item.TYPECODE_SOFTWARE,
                "튜링 머신",
                3200
        );

        System.out.println(book.toString());
        System.out.println(dvd.toString());
        System.out.println(soft.toString());
    }
}
