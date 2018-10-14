package com.idealo.toyrobot.model;

import java.io.Serializable;

public class CommandResponse implements Serializable {

    private Boolean success = Boolean.TRUE;
    private String errorMessage;
    private String outcome;

    public CommandResponse(Boolean success, String message) {
        this.success = success;
        this.errorMessage = message;
    }

    public CommandResponse(String outcome) {
        this.outcome = outcome;
    }

    public CommandResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getOutcome() {
        return outcome;
    }
}
