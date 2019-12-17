package com.swan.ee.typecodewithsubclass.refactoring;

public class ShapeRetangle extends Shape {
    public ShapeRetangle(int typecode, int startx, int starty, int endx, int endy) {
        super(typecode, startx, starty, endx, endy);
    }

    @Override
    public int getTypecode() {
        return Shape.TYPECODE_RECTANGLE;
    }

    @Override
    public String getName() {
        return "RETANGLE";
    }

    @Override
    public void draw() {
        drawRectangle();
    }

    private void drawRectangle() {
        System.out.println("drawRectangle " + this.toString());
    }

}
