package com.idealo.toyrobot.controller;

import com.idealo.toyrobot.manager.BoardManager;
import com.idealo.toyrobot.model.CommandRequest;
import com.idealo.toyrobot.model.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyRobotController {

    @Autowired
    private BoardManager boardManager;


    @PostMapping(value = "/execute")
    public ResponseEntity<CommandResponse> execute(@RequestBody CommandRequest commandRequest) {
        return new ResponseEntity<>(
                boardManager.executeCommand(commandRequest),
                HttpStatus.OK);
    }

}