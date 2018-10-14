package com.idealo.toyrobot.model;

import java.io.Serializable;

public class CommandRequest implements Serializable {

    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
