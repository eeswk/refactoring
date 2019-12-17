package com.swan.ee.errorcodewithexception.refactoring;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }

    public InvalidCommandException() {
    }
}
