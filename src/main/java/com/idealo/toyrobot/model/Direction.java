package com.idealo.toyrobot.model;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    static {
        NORTH.right = EAST;
        NORTH.left = WEST;
        EAST.right = SOUTH;
        EAST.left = NORTH;
        SOUTH.right = WEST;
        SOUTH.left = EAST;
        WEST.right = NORTH;
        WEST.left = SOUTH;
    }

    private Direction right;
    private Direction left;

    public Direction getRight() {
        return right;
    }

    public Direction getLeft() {
        return left;
    }
}
