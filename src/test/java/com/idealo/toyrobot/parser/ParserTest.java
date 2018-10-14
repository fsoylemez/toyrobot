package com.idealo.toyrobot.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.toyrobot.ToyRobotApplication;
import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.CommandParsingResponse;
import com.idealo.toyrobot.model.CommandRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ToyRobotApplication.class})
@ActiveProfiles("test")
@DirtiesContext
public class ParserTest {

    @Autowired
    CommandParser parser;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    Messages messages;

    @Value("classpath:parser/empty.json")
    Resource empty;

    @Value("classpath:parser/invalidCommand.json")
    Resource invalidCommand;

    @Value("classpath:parser/invalidNoofArgs.json")
    Resource invalidNoofArgs;

    @Value("classpath:parser/placeInvalidFormat.json")
    Resource placeInvalidFormat;

    @Value("classpath:parser/placeInvalidNoofArgs.json")
    Resource placeInvalidNoofArgs;

    @Value("classpath:parser/placeInvalidParams.json")
    Resource placeInvalidParams;


    @Test
    public void testEmptyCommand() throws IOException {
        CommandRequest commandRequest = mapper.readValue(
                empty.getFile(), CommandRequest.class);
        CommandParsingResponse response = parser.parseCommand(commandRequest.getCommand());

        assertThat(response).isNotNull().matches(a -> a.getValidCommand() == Boolean.FALSE
                && messages.get("toyrobot.command.not.found").equals(a.getErrorMessage()));

    }

    @Test
    public void testInvalidCommand() throws IOException {
        CommandRequest commandRequest = mapper.readValue(
                invalidCommand.getFile(), CommandRequest.class);
        CommandParsingResponse response = parser.parseCommand(commandRequest.getCommand());

        assertThat(response).isNotNull().matches(a -> a.getValidCommand() == Boolean.FALSE
                && messages.get("toyrobot.invalid.command").equals(a.getErrorMessage()));

    }

    @Test
    public void testInvalidNoofArgs() throws IOException {
        CommandRequest commandRequest = mapper.readValue(
                invalidNoofArgs.getFile(), CommandRequest.class);
        CommandParsingResponse response = parser.parseCommand(commandRequest.getCommand());

        assertThat(response).isNotNull().matches(a -> a.getValidCommand() == Boolean.FALSE
                && messages.get("toyrobot.invalid.command").equals(a.getErrorMessage()));

    }

    @Test
    public void testPlaceInvalidFormat() throws IOException {
        CommandRequest commandRequest = mapper.readValue(
                placeInvalidFormat.getFile(), CommandRequest.class);
        CommandParsingResponse response = parser.parseCommand(commandRequest.getCommand());

        assertThat(response).isNotNull().matches(a -> a.getValidCommand() == Boolean.FALSE
                && messages.get("toyrobot.invalid.format").equals(a.getErrorMessage()));

    }

    @Test
    public void testPlaceInvalidNoofArgs() throws IOException {
        CommandRequest commandRequest = mapper.readValue(
                placeInvalidNoofArgs.getFile(), CommandRequest.class);
        CommandParsingResponse response = parser.parseCommand(commandRequest.getCommand());

        assertThat(response).isNotNull().matches(a -> a.getValidCommand() == Boolean.FALSE
                && messages.get("toyrobot.invalid.noof.args").equals(a.getErrorMessage()));

    }

    @Test
    public void testPlaceInvalidParams() throws IOException {
        CommandRequest commandRequest = mapper.readValue(
                placeInvalidParams.getFile(), CommandRequest.class);
        CommandParsingResponse response = parser.parseCommand(commandRequest.getCommand());

        assertThat(response).isNotNull().matches(a -> a.getValidCommand() == Boolean.FALSE
                && messages.get("toyrobot.invalid.params").equals(a.getErrorMessage()));

    }
}
