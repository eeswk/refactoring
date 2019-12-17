package com.swan.ee.constructorwithfactorymethod.before;

public class Shape {
    public static final int TYPECODE_LINE = 0;
    public static final int TYPECODE_RECTANGLE = 1;
    public static final int TYPECODE_OVAL = 2;

    private final int _typecode;
    private final int _startx;
    private final int _starty;
    private final int _endx;
    private final int _endy;

    public Shape(int _typecode, int _startx, int _starty, int _endx, int _endy) {
        this._typecode = _typecode;
        this._startx = _startx;
        this._starty = _starty;
        this._endx = _endx;
        this._endy = _endy;
    }

    public int getTypecode() {
        return _typecode;
    }

    public String getName() {
        switch (_typecode) {
            case TYPECODE_LINE:
                return "LINE";
            case TYPECODE_RECTANGLE:
                return "RECTANGLE";
            case TYPECODE_OVAL:
                return "OVAL";
            default:
                return null;
        }
    }

    public void draw() {
        switch (_typecode) {
            case TYPECODE_LINE :
                drawLine();
                break;
            case TYPECODE_RECTANGLE:
                drawRectangle();
                break;
            case TYPECODE_OVAL :
                drawOval();
                break;
            default:
                ;
        }
    }

    private void drawLine() {
        System.out.println("drawLine : " + this.toString());
    }

    private void drawRectangle() {
        System.out.println("drawRectangle : " + this.toString());
    }

    private void drawOval() {
        System.out.println("drawOval : " + this.toString());
    }


    @Override
    public String toString() {
        return "Shape{" +
                "_typecode=" + _typecode +
                ", _startx=" + _startx +
                ", _starty=" + _starty +
                ", _endx=" + _endx +
                ", _endy=" + _endy +
                '}';
    }
}
