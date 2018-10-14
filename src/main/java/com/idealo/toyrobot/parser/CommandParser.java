package com.idealo.toyrobot.parser;

import com.idealo.toyrobot.constants.CommandConstants;
import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandParser {

    @Autowired
    Messages messages;


    public CommandParsingResponse parseCommand(String commandText) {
        if (commandText == null || commandText.isEmpty())
            return new CommandParsingResponse(false, messages.get("toyrobot.command.not.found"));

        if (commandText.startsWith(CommandConstants.PLACE_COMMAND)) {
            return parsePlaceCommand(commandText);
        }

        CommandType commandType = null;
        try {
            commandType = CommandType.valueOf(commandText.trim());
        } catch (IllegalArgumentException e) {
            return new CommandParsingResponse(false, messages.get("toyrobot.invalid.command"));
        }

        return new CommandParsingResponse(new Command(commandType));
    }

    public CommandParsingResponse parsePlaceCommand(String commandText) {
        String[] arguments = commandText.split(" ");
        if (arguments == null || arguments.length != 2) {
            return new CommandParsingResponse(false, messages.get("toyrobot.invalid.noof.args"));
        }
        String[] parameters = arguments[1].split(",");
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
