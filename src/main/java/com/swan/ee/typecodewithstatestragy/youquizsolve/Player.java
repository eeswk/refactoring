package com.swan.ee.typecodewithstatestragy.youquizsolve;

class Media {
    public static Media NULL = new Media();
    public static Media VIDEO = new Media();
    public static Media MUSIC = new Media();
}


class Player {
    private Media _media = new Media();

    public void play() {
        if (_media == Media.VIDEO ) {
            System.out.println("Video: play");
        } else if (_media == Media.MUSIC) {
            System.out.println("Music: play");
        } else if (_media == Media.NULL) {
            System.out.println("Null: play");
        } else {
            assert false;
        }
    }

    public void loop() {
        if (_media == Media.VIDEO ) {
            System.out.println("Video: loop");
        } else if (_media == Media.MUSIC) {
            System.out.println("Music: loop");
        } else if (_media == Media.NULL) {
            System.out.println("Null: loop");
        } else {
            assert false;
        }
    }

    public void stop() {
        if (_media == Media.VIDEO ) {
            System.out.println("Video: stop");
        } else if (_media == Media.MUSIC) {
            System.out.println("Music: stop");
        } else if (_media == Media.NULL) {
            System.out.println("Null: stop");
        } else {
            assert false;
        }
    }

    public void setMedia(Media media) {
        if (media == null) {
            _media = Media.NULL;
        } else {
            _media = media;
        }
    }
}
