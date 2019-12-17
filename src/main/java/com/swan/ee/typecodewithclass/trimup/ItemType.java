package com.swan.ee.typecodewithclass.trimup;

public enum ItemType {
    BOOK(0),
    DVD(1),
    SOFTWARE(2);

    private final int typecode;

    ItemType(int typecode) {
        this.typecode = typecode;
    }

    public int getTypecode() {
        return typecode;
    }
}
