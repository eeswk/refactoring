package com.swan.ee.typecodewithsubclass.youquizslove;

public class Main {
    public static void main(String[] args) {
        Player music = Player.crate(Player.MUSIC);
        Player video = Player.crate(Player.VIDEO);

        Player[] players = {music, video};

        for (Player p: players) {
            p.play();
            p.loop();
            p.stop();
        }
    }
}
