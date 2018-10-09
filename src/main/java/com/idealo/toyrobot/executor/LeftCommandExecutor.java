package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.model.Robot;

public class LeftCommandExecutor implements CommandExecutor  {
    @Override
    public Robot execute(Robot robot, String command) {
        if(robot==null)
            return null;
        robot.setDirection(robot.getDirection().getLeft());
        return robot;
    }
}
