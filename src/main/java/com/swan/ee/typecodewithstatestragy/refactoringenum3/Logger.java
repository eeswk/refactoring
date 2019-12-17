package com.swan.ee.typecodewithstatestragy.refactoringenum3;

public class Logger {

    private enum State {
        STOPPED {

            @Override public void start() {
                System.out.println("** START LOGGING **");
            }

            @Override public void stop() {

            }

            @Override public void log(String info) {
                System.out.println("Ignore : " + info);
            }
        }
        , LOGGING {

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

    private State _state;

    public Logger() {
        setState(State.STOPPED);
    }

    public State getState() {
        return _state;
    }

    public void setState(State state) {
        _state = state;
    }

    public void start() {
        _state.start();
        setState(State.LOGGING);
    }

    public void stop() {
        _state.stop();
        setState(State.STOPPED);
    }

    public void log(String info) {
        _state.log(info);
    }
}
