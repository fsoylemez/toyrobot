package com.idealo.toyrobot.model;

public enum Direction {
    NORTH(Direction.EAST,Direction.WEST),
    EAST(Direction.SOUTH,Direction.NORTH),
    SOUTH(Direction.WEST,Direction.EAST),
    WEST(Direction.NORTH,Direction.SOUTH);

    Direction right;
    Direction left;

     Direction(Direction right,Direction left){
        this.right = right;
        this.left = left;
    }

    public Direction getRight() {
        return right;
    }

    public Direction getLeft() {
        return left;
    }
}
