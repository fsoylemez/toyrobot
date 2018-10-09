package com.idealo.toyrobot.controller;

import com.idealo.toyrobot.manager.BoardManager;
import com.idealo.toyrobot.model.BulkCommandRequest;
import com.idealo.toyrobot.model.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToyRobotController {

    @Autowired
    private BoardManager boardManager;


/*
    @RequestMapping("/")
    public String index() {
        return boardManager.boardSize();
    }
*/

    @RequestMapping( value = "/bulk", method = RequestMethod.POST )
    public ResponseEntity<Outcome> bulkProcess(@RequestBody BulkCommandRequest commandRequest)
    {
        return new ResponseEntity<>(
                boardManager.processBulk( commandRequest ),
                HttpStatus.OK );
    }

}