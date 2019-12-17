package com.swan.ee.typecodewithclass.refactoring;

public class ItemType {
    public static final ItemType BOOK = new ItemType(0);
    public static final ItemType DVD = new ItemType(1);
    public static final ItemType SOFTWARE = new ItemType(2);

    private int typecode;

    public ItemType(int typecode) {
        this.typecode = typecode;
    }

    public int getTypecode() {
        return typecode;
    }

    //분류코드에서 ItemType 클래스 인스턴스를 얻기 위한 getItemType 메서드
    //추후 삭제
    public static ItemType getItemTypc(int typecode) {
        switch (typecode) {
            case 0 : return BOOK;
            case 1 : return DVD;
            case 2 : return SOFTWARE;
            default: return null;
        }
    }
}
