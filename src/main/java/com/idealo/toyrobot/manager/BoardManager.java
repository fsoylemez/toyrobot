package com.idealo.toyrobot.manager;

import com.idealo.toyrobot.configuration.CommandExecutorFactory;
import com.idealo.toyrobot.executor.PlaceCommandExecutor;
import com.idealo.toyrobot.model.*;
import com.idealo.toyrobot.parser.CommandParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BoardManager {

    @Autowired
    CommandExecutorFactory commandExecutorFactory;

    @Autowired
    CommandParser parser;

    @Autowired
    PlaceCommandExecutor place;


    public CommandResponse executeCommand(CommandRequest commandRequest) {
        CommandParsingResponse parsingResponse = parser.parseCommand(commandRequest.getCommand());

        if (!parsingResponse.getValidCommand()) {
            return new CommandResponse(false, parsingResponse.getErrorMessage());
        }

        if (CommandType.PLACE.equals(parsingResponse.getCommand().getCommandType()))
            return place.execute((PlaceCommand) parsingResponse.getCommand());

        return commandExecutorFactory.getExecutor(parsingResponse.getCommand().getCommandType().name().toLowerCase(Locale.ENGLISH)).execute();
    }
}
