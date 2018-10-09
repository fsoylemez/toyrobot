package com.idealo.toyrobot.manager;

import com.idealo.toyrobot.configuration.CommandExecutorFactory;
import com.idealo.toyrobot.executor.CommandExecutor;
import com.idealo.toyrobot.model.BulkCommandRequest;
import com.idealo.toyrobot.model.Outcome;
import com.idealo.toyrobot.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardManager {

    @Autowired
    CommandExecutorFactory executorFactory;

    private Robot robot;

    public Outcome processBulk(BulkCommandRequest commandRequest) {

        for( String command : commandRequest.getCommands()){
            CommandExecutor ce = executorFactory.getExecutor("somecommand");
            robot = ce.execute(robot,command);
        }

        return null;
    }
}
