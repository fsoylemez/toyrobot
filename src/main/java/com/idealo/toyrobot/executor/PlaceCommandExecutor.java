package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import com.idealo.toyrobot.model.PlaceCommand;
import com.idealo.toyrobot.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Places robot onto the given location
 *
 * @author  Fatih Soylemez
 * @version 1.0
 * @since   2018-10-14
 */
@Service(value = "place")
public class PlaceCommandExecutor {

    @Autowired
    Board board;

    @Autowired
    Messages messages;


    /**
     * Places robot onto board
     * works with arguments since it requires some information
     * @param command
     * @return CommandResponse
     */
    public CommandResponse execute(PlaceCommand command) {

        if (command.getxCoordinate() < 0 || command.getxCoordinate() >= Integer.valueOf(board.getBoardXDimension())
                || command.getyCoordinate() < 0 || command.getyCoordinate() >= Integer.valueOf(board.getBoardYDimension())) {
            return new CommandResponse(false, messages.get("toyrobot.cant.place"));
        }

        Robot robot = new Robot(command.getxCoordinate(), command.getyCoordinate(), command.getDirection());

        board.setRobot(robot);
        return new CommandResponse();
    }
}
