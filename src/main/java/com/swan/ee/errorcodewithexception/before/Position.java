package com.swan.ee.errorcodewithexception.before;

public class Position {
    public int _x;
    public int _y;

    public Position(int x, int y) {
        this._x = x;
        this._y = y;
    }

    public void relativeMove(int dx, int dy) {
        this._x += dx;
        this._y += dy;
    }
}
