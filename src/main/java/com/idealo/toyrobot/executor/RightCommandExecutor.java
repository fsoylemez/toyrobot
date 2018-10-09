package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.model.Robot;

public class RightCommandExecutor implements CommandExecutor  {
    @Override
    public Robot execute(Robot robot, String command) {
        if(robot==null)
            return null;
        robot.setDirection(robot.getDirection().getRight());
        return robot;
    }
}
