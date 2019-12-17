package com.swan.ee.typecodewithsubclass.youquizslove;

public abstract class Player {
    public static final int MUSIC = 0;
    public static final int VIDEO = 1;


    public static Player crate(int type) {
        switch (type) {
            case MUSIC :
                return new MusicPlayer();
            case VIDEO :
                return new VideoPlayer();
            default:
                throw new IllegalArgumentException("type = " + type);
        }
    }

    public abstract void play();
    public abstract void loop();
    public abstract void stop();

}
