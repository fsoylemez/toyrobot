package com.idealo.toyrobot.model;

import java.io.Serializable;

public class Outcome implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
