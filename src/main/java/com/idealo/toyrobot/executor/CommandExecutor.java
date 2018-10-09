package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.model.Robot;

public interface CommandExecutor {
    Robot execute(Robot robot, String command);
}
