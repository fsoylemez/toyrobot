package com.idealo.toyrobot.model;

public class PlaceCommand extends Command {

    private Integer xCoordinate;

    private Integer yCoordinate;

    private Direction direction;

    public PlaceCommand(CommandType commandType, Integer xCoordinate, Integer yCoordinate, Direction direction) {
        this.setCommandType(commandType);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }

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
