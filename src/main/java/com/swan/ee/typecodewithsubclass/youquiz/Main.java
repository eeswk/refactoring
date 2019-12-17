package com.swan.ee.typecodewithsubclass.youquiz;

public class Main {
    public static void main(String[] args) {
        Player music = new Player(Player.MUSIC);
        Player video = new Player(Player.VIDEO);

        Player[] players = {music, video};

        for (Player p : players) {
            p.play();
            p.loop();
            p.stop();
        }
    }
}
