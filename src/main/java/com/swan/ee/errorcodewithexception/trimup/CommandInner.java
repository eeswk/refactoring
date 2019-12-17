package com.swan.ee.errorcodewithexception.trimup;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.text.Position.Bias.Backward;
import static javax.swing.text.Position.Bias.Forward;

public abstract class CommandInner {
    public static final CommandInner FORWARD = new CommandInner("forward") {
        @Override
        public void execute(Robot robot) {
            robot.forward();
        }
    };
    public static final CommandInner BACKWARD = new CommandInner("backward") {
        @Override
        public void execute(Robot robot) {
            robot.backward();
        }
    };
    public static final CommandInner TURN_RIGHT = new CommandInner("right") {
        @Override
        public void execute(Robot robot) {
            robot.right();
        }
    };
    public static final CommandInner TURN_LEFT = new CommandInner("left") {
        @Override
        public void execute(Robot robot) {
            robot.left();
        }
    };

    private static final Map<String, CommandInner> commandNameMap = new HashMap<>();
    static {
        commandNameMap.put(FORWARD.name, FORWARD);
        commandNameMap.put(BACKWARD.name, BACKWARD);
        commandNameMap.put(TURN_RIGHT.name, TURN_RIGHT);
        commandNameMap.put(TURN_LEFT.name, TURN_LEFT);
    }

    private final String name;

    protected CommandInner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CommandInner parseCommand(String name) throws InvalidCommandException {
        if (!commandNameMap.containsKey(name)) {
            throw new InvalidCommandException(name);
        }
        return commandNameMap.get(name);
    }

    public abstract void execute(Robot robot);


}
