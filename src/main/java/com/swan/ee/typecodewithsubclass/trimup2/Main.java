package com.swan.ee.typecodewithsubclass.trimup2;

public class Main {
    public static void main(String[] args) {
        Shape line = Shape.createShapeLine(0, 0, 100, 200);
        Shape rectangle = Shape.createShapeRectangle(10, 20, 30, 40);
        Shape oval = Shape.createShapeOval(100, 200, 300, 400);

        Shape[] shapes = {line, rectangle, oval};

        for (Shape s : shapes) {
            s.draw();
        }

    }
}
