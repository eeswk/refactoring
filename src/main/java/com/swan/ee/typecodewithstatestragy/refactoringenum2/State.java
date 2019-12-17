package com.swan.ee.typecodewithstatestragy.refactoringenum2;

public enum State {
    STATE_STOPPED {

        @Override public void start() {
            System.out.println("** START LOGGING **");
        }

        @Override public void stop() {

        }

        @Override public void log(String info) {
            System.out.println("Ignore : " + info);
        }
    }
    , STATE_LOGGING {

        @Override public void start() {
        }

        @Override public void stop() {
            System.out.println("** STOP LOGGING **");
        }

        @Override public void log(String info) {
            System.out.println("Logging : " + info);
        }
    };

    abstract void start();
    abstract void stop();
    abstract void log(String info);
}
