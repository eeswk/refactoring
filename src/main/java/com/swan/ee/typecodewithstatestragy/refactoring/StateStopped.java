package com.swan.ee.typecodewithstatestragy.refactoring;

public class StateStopped extends State {
    @Override
    public int getTypeCode() {
        return Logger.STATE_STOPPED;
    }
}
