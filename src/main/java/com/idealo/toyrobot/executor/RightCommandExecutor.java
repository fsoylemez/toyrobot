package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import com.idealo.toyrobot.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Turns robot to right by one unit
 *
 * @author  Fatih Soylemez
 * @version 1.0
 * @since   2018-10-14
 */
@Service(value = "right")
public class RightCommandExecutor implements CommandExecutor {

    private static final Logger LOG = LoggerFactory.getLogger( RightCommandExecutor.class );


    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Override
    public CommandResponse execute() {

        Robot robot = board.getRobot();
        if (robot == null)
            return new CommandResponse(false, messages.get("toyrobot.no.robot"));

        LOG.info("Turning right from,"+robot.getDirection().name());

        robot.setDirection(robot.getDirection().getRight());
        board.setRobot(robot);
        return new CommandResponse();
    }
}
