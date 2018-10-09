package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.model.Robot;
import org.springframework.beans.factory.annotation.Value;

public class MoveCommandExecutor implements CommandExecutor  {

    @Value( "${spring.board.x.dimension}" )
    private String boardXDimension;

    @Value( "${spring.board.y.dimension}" )
    private String boardYDimension;

    @Override
    public Robot execute(Robot robot, String command) {
        if(robot==null)
            return null;
        switch (robot.getDirection()){
            case NORTH:
                if(robot.getyCoordinate()+1<Integer.valueOf(boardYDimension))
                    robot.setyCoordinate(robot.getyCoordinate()+1);
            case SOUTH:
                if(robot.getyCoordinate()-1>=0)
                    robot.setyCoordinate(robot.getyCoordinate()-1);
            case EAST:
                if(robot.getxCoordinate()+1<Integer.valueOf(boardYDimension))
                    robot.setxCoordinate(robot.getxCoordinate()+1);
            case WEST:
                if(robot.getxCoordinate()-1>=0)
                    robot.setxCoordinate(robot.getxCoordinate()-1);
        }
        return robot;
    }
}
