package com.swan.ee.typecodewithsubclass.youquiz;

public class Player {
    public static final int MUSIC = 0;
    public static final int VIDEO = 1;
    private final int _type;

    public Player(int type) {
        if(type != MUSIC && type != VIDEO) {
            throw new IllegalArgumentException("type = " + type);
        }
        _type = type;
    }

    public void play() {
        switch (_type) {
            case MUSIC :
                System.out.println("Music : play");
                break;
            case VIDEO :
                System.out.println("Video : play");
                break;
            default:
                assert false;

        }
    }

    public void loop() {
        switch (_type) {
            case MUSIC :
                System.out.println("Music : loop");
                break;
            case VIDEO :
                System.out.println("Video : loop");
                break;
            default:
                assert false;
        }
    }

    public void stop() {
        switch (_type) {
            case MUSIC :
                System.out.println("Music : stop");
                break;
            case VIDEO :
                System.out.println("Video : stop");
                break;
            default:
                assert false;

        }
    }
}
