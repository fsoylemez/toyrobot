package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import com.idealo.toyrobot.model.PlaceCommand;
import com.idealo.toyrobot.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "place")
public class PlaceCommandExecutor {

    @Autowired
    Board board;

    @Autowired
    Messages messages;

    public CommandResponse execute(PlaceCommand command) {

        if (command.getxCoordinate() < 0 | command.getxCoordinate() >= Integer.valueOf(board.getBoardXDimension()) | command.getyCoordinate() < 0 | command.getyCoordinate() >= Integer.valueOf(board.getBoardYDimension())) {
            return new CommandResponse(false, messages.get("toyrobot.cant.place"));
        }

        Robot robot = new Robot(command.getxCoordinate(), command.getyCoordinate(), command.getDirection());

        board.setRobot(robot);
        return new CommandResponse();
    }
}
