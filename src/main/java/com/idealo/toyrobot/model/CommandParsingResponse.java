package com.idealo.toyrobot.model;

public class CommandParsingResponse {

    private Command command;

    private Boolean isValidCommand = Boolean.TRUE;

    private String errorMessage;

    public CommandParsingResponse(boolean isValidCommand, String errorMessage) {
        this.isValidCommand = isValidCommand;
        this.errorMessage = errorMessage;
    }

    public CommandParsingResponse(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public Boolean getValidCommand() {
        return isValidCommand;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
