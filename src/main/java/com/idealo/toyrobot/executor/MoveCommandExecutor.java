package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import com.idealo.toyrobot.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "move")
public class MoveCommandExecutor implements CommandExecutor {

    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Override
    public CommandResponse execute() {
        Robot robot = board.getRobot();

        if (robot == null)
            return new CommandResponse(false, messages.get("toyrobot.no.robot"));
        boolean canMove = true;
        switch (robot.getDirection()) {
            case NORTH:
                if (robot.getyCoordinate() + 1 < Integer.valueOf(board.getBoardYDimension()))
                    robot.setyCoordinate(robot.getyCoordinate() + 1);
                else
                    canMove = false;
                break;
            case SOUTH:
                if (robot.getyCoordinate() - 1 >= 0)
                    robot.setyCoordinate(robot.getyCoordinate() - 1);
                else
                    canMove = false;
                break;
            case EAST:
                if (robot.getxCoordinate() + 1 < Integer.valueOf(board.getBoardXDimension()))
                    robot.setxCoordinate(robot.getxCoordinate() + 1);
                else
                    canMove = false;
                break;
            case WEST:
                if (robot.getxCoordinate() - 1 >= 0)
                    robot.setxCoordinate(robot.getxCoordinate() - 1);
                else
                    canMove = false;
                break;
        }

        if (!canMove) {
            return new CommandResponse(false, messages.get("toyrobot.cant.move"));
        }
        board.setRobot(robot);
        return new CommandResponse();
    }
}
