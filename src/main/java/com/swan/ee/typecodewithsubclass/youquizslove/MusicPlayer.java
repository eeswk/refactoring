package com.swan.ee.typecodewithsubclass.youquizslove;

public class MusicPlayer extends Player{

    @Override
    public void play() {
        System.out.println("Music: play");
    }

    @Override
    public void stop() {
        System.out.println("Music: Stop");
    }

    @Override
    public void loop() {
        System.out.println("Music: loop");
    }
}
