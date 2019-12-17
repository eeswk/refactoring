package com.swan.ee.typecodewithsubclass.youquizslove;

public class VideoPlayer extends Player {

    @Override
    public void play() {
        System.out.println("Video: play");
    }

    @Override
    public void stop() {
        System.out.println("Video: Stop");
    }

    @Override
    public void loop() {
        System.out.println("Video: loop");
    }
}
