package com.idealo.toyrobot.configuration;

import com.idealo.toyrobot.executor.CommandExecutor;

public interface CommandExecutorFactory {

    CommandExecutor getExecutor(String key);

}
