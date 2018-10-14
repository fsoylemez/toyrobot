package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import com.idealo.toyrobot.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "right")
public class RightCommandExecutor implements CommandExecutor {

    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Override
    public CommandResponse execute() {
        Robot robot = board.getRobot();
        if (robot == null)
            return new CommandResponse(false, messages.get("toyrobot.no.robot"));
        robot.setDirection(robot.getDirection().getRight());
        board.setRobot(robot);
        return new CommandResponse();
    }
}
