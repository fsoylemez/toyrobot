package com.idealo.toyrobot.model;

import java.io.Serializable;


public class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer xDimension;

    private Integer yDimension;

    public Board(Integer boardXDimension, Integer boardYDimension) {
    }

    public Board() {}

    public Integer getxDimension() {
        return xDimension;
    }

    public void setxDimension(Integer xDimension) {
        this.xDimension = xDimension;
    }

    public Integer getyDimension() {
        return yDimension;
    }

    public void setyDimension(Integer yDimension) {
        this.yDimension = yDimension;
    }
}
