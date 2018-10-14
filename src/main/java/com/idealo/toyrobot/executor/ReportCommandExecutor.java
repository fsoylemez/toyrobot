package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Reports robot's current position
 * in a format xCoordinate,yCoordinate,Direction
 *
 * @author  Fatih Soylemez
 * @version 1.0
 * @since   2018-10-14
 */
@Service(value = "report")
public class ReportCommandExecutor implements CommandExecutor {

    private static final Logger LOG = LoggerFactory.getLogger( ReportCommandExecutor.class );


    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Override
    public CommandResponse execute() {

        if (board.getRobot() == null)
            return new CommandResponse(false, messages.get("toyrobot.no.robot"));

        LOG.info("Reporting status : "+board.getRobot().status());
        return new CommandResponse(board.getRobot().status());
    }

}
