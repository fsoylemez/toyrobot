package com.idealo.toyrobot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.toyrobot.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ToyRobotControllerTest {

    @Autowired
    Board board;

    @Autowired
    ObjectMapper mapper;

    @Value("classpath:manager/left.json")
    Resource left;

    @Value("classpath:manager/move.json")
    Resource move;

    @Value("classpath:manager/place.json")
    Resource place;

    @Value("classpath:manager/report.json")
    Resource report;

    @Value("classpath:manager/right.json")
    Resource right;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPlace() throws IOException {
        CommandRequest request = mapper.readValue(place.getFile(),CommandRequest.class);
        CommandResponse response = this.restTemplate.postForObject("http://localhost:" + port + "/toyrobot/execute",
                request,CommandResponse.class);

        Assert.assertNotNull(board.getRobot());
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(2),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(4),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.EAST,board.getRobot().getDirection());

    }

    @Test
    public void testMove() throws IOException {
        Robot robot = new Robot(1,2, Direction.NORTH);
        board.setRobot(robot);

        CommandRequest request = mapper.readValue(move.getFile(),CommandRequest.class);
        CommandResponse response = this.restTemplate.postForObject("http://localhost:" + port + "/toyrobot/execute",
                request,CommandResponse.class);

        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(1),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(3),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.NORTH,board.getRobot().getDirection());

    }

    @Test
    public void testLeft() throws IOException {
        Robot robot = new Robot(1,2, Direction.NORTH);
        board.setRobot(robot);

        CommandRequest request = mapper.readValue(left.getFile(),CommandRequest.class);
        CommandResponse response = this.restTemplate.postForObject("http://localhost:" + port + "/toyrobot/execute",
                request,CommandResponse.class);

        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(1),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(2),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.WEST,board.getRobot().getDirection());

    }

    @Test
    public void testRight() throws IOException {
        Robot robot = new Robot(1,2, Direction.NORTH);
        board.setRobot(robot);

        CommandRequest request = mapper.readValue(right.getFile(),CommandRequest.class);
        CommandResponse response = this.restTemplate.postForObject("http://localhost:" + port + "/toyrobot/execute",
                request,CommandResponse.class);

        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(1),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(2),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.EAST,board.getRobot().getDirection());
    }

    @Test
    public void testReport() throws IOException {
        Robot robot = new Robot(1,2, Direction.NORTH);
        board.setRobot(robot);

        CommandRequest request = mapper.readValue(report.getFile(),CommandRequest.class);
        CommandResponse response = this.restTemplate.postForObject("http://localhost:" + port + "/toyrobot/execute",
                request,CommandResponse.class);

        assertThat(response).isNotNull().matches(r->r.getSuccess()==Boolean.TRUE &&
                r.getErrorMessage()==null && r.getOutcome().equals("1,2,NORTH"));
    }
}
