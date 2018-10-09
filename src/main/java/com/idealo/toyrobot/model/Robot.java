package com.idealo.toyrobot.model;

import java.io.Serializable;


public class Robot implements Serializable{
    private static final long serialVersionUID = 1L;


    private Integer xCoordinate;

    private Integer yCoordinate;

    private Direction direction;


    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
