package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.model.Direction;
import com.idealo.toyrobot.model.Robot;
import org.springframework.beans.factory.annotation.Value;

public class PlaceCommandExecutor implements CommandExecutor {

    @Value( "${spring.board.x.dimension}" )
    private String boardXDimension;

    @Value( "${spring.board.y.dimension}" )
    private String boardYDimension;

    @Override
    public Robot execute(Robot robot, String command) {
        if(command==null || command.isEmpty())
            return robot;
        String[] statement = command.split(" ");
        if(statement==null || statement.length!=2)
            return robot;
        String[] parameters = statement[1].split(",");
        if(parameters==null || parameters.length!=3)
            return robot;
        int xCoor,yCoor;
        Direction direction;
        try {
            xCoor = Integer.parseInt(parameters[0]);
            yCoor = Integer.parseInt(parameters[1]);
            direction = Direction.valueOf(parameters[2]);
        }
        catch (IllegalArgumentException e){
            return robot;
        }
        if(xCoor<0 | xCoor>=Integer.valueOf(boardXDimension) | yCoor<0 | yCoor>=Integer.valueOf(boardYDimension))
            return robot;

        robot.setxCoordinate(xCoor);
        robot.setyCoordinate(yCoor);
        robot.setDirection(direction);

        return robot;
    }
}
