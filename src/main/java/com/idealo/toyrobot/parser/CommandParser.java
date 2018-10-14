package com.idealo.toyrobot.parser;

import com.idealo.toyrobot.constants.CommandConstants;
import com.idealo.toyrobot.executor.LeftCommandExecutor;
import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Parses cleartext command
 * The place command is treated differently
 * since it requires some parameters to function
 *
 * @author  Fatih Soylemez
 * @version 1.0
 * @since   2018-10-14
 */
@Service
public class CommandParser {

    private static final Logger LOG = LoggerFactory.getLogger( CommandParser.class );


    @Autowired
    Messages messages;

    /**
     * Parses command text and sets
     * error messages accordinlgy
     * @param commandText
     * @return CommandParsingResponse
     */
    public CommandParsingResponse parseCommand(String commandText) {
        if (commandText == null || commandText.isEmpty())
            return new CommandParsingResponse(false, messages.get("toyrobot.command.not.found"));

        if (commandText.startsWith(CommandConstants.PLACE_COMMAND)) {
            LOG.info("Place command will be executed.");
            return parsePlaceCommand(commandText);
        }

        CommandType commandType = null;
        try {
            commandType = CommandType.valueOf(commandText.trim());
        } catch (IllegalArgumentException e) {
            LOG.info("Could not find command.");
            return new CommandParsingResponse(false, messages.get("toyrobot.invalid.command"));
        }

        return new CommandParsingResponse(new Command(commandType));
    }

    public CommandParsingResponse parsePlaceCommand(String commandText) {
        String[] arguments = commandText.split(CommandConstants.SPACE_SPLITTER);
        if (arguments == null || arguments.length != 2) {
            return new CommandParsingResponse(false, messages.get("toyrobot.invalid.noof.args"));
        }
        String[] parameters = arguments[1].split(CommandConstants.COLON_SPLITTER);
        if (parameters == null || parameters.length != 3) {
            return new CommandParsingResponse(false, messages.get("toyrobot.invalid.params"));
        }
        int xCoor, yCoor;
        Direction direction;
        try {
            xCoor = Integer.parseInt(parameters[0]);
            yCoor = Integer.parseInt(parameters[1]);
            direction = Direction.valueOf(parameters[2]);
        } catch (IllegalArgumentException e) {
            return new CommandParsingResponse(false, messages.get("toyrobot.invalid.format"));
        }
        return new CommandParsingResponse(new PlaceCommand(CommandType.PLACE, xCoor, yCoor, direction));
    }


}
