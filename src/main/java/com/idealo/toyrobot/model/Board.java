package com.idealo.toyrobot.model;


import org.springframework.beans.factory.annotation.Value;

public class Board {

    @Value("${spring.board.x.dimension}")
    private String boardXDimension;

    @Value("${spring.board.y.dimension}")
    private String boardYDimension;

    private Robot robot;

    public Board() {
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public String getBoardXDimension() {
        return boardXDimension;
    }

    public String getBoardYDimension() {
        return boardYDimension;
    }
}
