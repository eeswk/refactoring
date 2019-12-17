package com.swan.ee.typecodewithstatestragy.refactoring;

public class StateLogging extends State {
    @Override
    public int getTypeCode() {
        return Logger.STATE_LOGGING;
    }
}
