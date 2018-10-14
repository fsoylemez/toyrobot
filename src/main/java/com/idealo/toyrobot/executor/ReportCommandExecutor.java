package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "report")
public class ReportCommandExecutor implements CommandExecutor {

    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Override
    public CommandResponse execute() {
        if (board.getRobot() == null)
            return new CommandResponse(false, messages.get("toyrobot.no.robot"));

        return new CommandResponse(board.getRobot().status());
    }

}
