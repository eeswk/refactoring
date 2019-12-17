package com.swan.ee.constructorwithfactorymethod.refactoring2;

public abstract class Shape {
    private final int _startx;
    private final int _starty;
    private final int _endx;
    private final int _endy;


    public static Shape createLine(int startx, int starty, int endx, int endy) {
        return new ShapeLine(startx, starty, endx, endy);
    }

    public static Shape createRectangle(int startx, int starty, int endx, int endy) {
        return new ShapeRectangle(startx, starty, endx, endy);
    }

    public static Shape createOval(int startx, int starty, int endx, int endy) {
        return new ShapeOval(startx, starty, endx, endy);
    }

    protected Shape(int _startx, int _starty, int _endx, int _endy) {
        this._startx = _startx;
        this._starty = _starty;
        this._endx = _endx;
        this._endy = _endy;
    }


    public abstract String getName();

    public abstract void draw();

    @Override
    public String toString() {
        return "Shape{" +
                "_typecode=" + getName() +
                ", _startx=" + _startx +
                ", _starty=" + _starty +
                ", _endx=" + _endx +
                ", _endy=" + _endy +
                '}';
    }
}
