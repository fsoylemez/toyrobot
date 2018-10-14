package com.idealo.toyrobot.model;

public class Command {

    private CommandType commandType;

    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    public Command() {
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }
}
