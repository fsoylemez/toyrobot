package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.ToyRobotApplication;
import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
import com.idealo.toyrobot.model.Direction;
import com.idealo.toyrobot.model.Robot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ToyRobotApplication.class})
@ActiveProfiles("test")
@DirtiesContext
public class MoveExecutorTest {

    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Autowired
    MoveCommandExecutor move;

    @Test
    public void testCantMoveNorth(){
        Robot robot = new Robot(1,4, Direction.NORTH);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.FALSE
        && messages.get("toyrobot.cant.move").equals(p.getErrorMessage()));
        Assert.assertEquals(new Integer(1),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(4),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.NORTH,board.getRobot().getDirection());
    }

    @Test
    public void testMoveNorth(){
        Robot robot = new Robot(1,3, Direction.NORTH);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(1),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(4),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.NORTH,board.getRobot().getDirection());
    }

    @Test
    public void testCantMoveSouth(){
        Robot robot = new Robot(3,0, Direction.SOUTH);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.FALSE
                && messages.get("toyrobot.cant.move").equals(p.getErrorMessage()));
        Assert.assertEquals(new Integer(3),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(0),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.SOUTH,board.getRobot().getDirection());
    }

    @Test
    public void testMoveSouth(){
        Robot robot = new Robot(3,1, Direction.SOUTH);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(3),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(0),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.SOUTH,board.getRobot().getDirection());
    }

    @Test
    public void testCantMoveWest(){
        Robot robot = new Robot(0,2, Direction.WEST);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.FALSE
                && messages.get("toyrobot.cant.move").equals(p.getErrorMessage()));
        Assert.assertEquals(new Integer(0),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(2),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.WEST,board.getRobot().getDirection());
    }

    @Test
    public void testMoveWest(){
        Robot robot = new Robot(3,1, Direction.WEST);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(2),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(1),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.WEST,board.getRobot().getDirection());
    }

    @Test
    public void testCantMoveEast(){
        Robot robot = new Robot(4,2, Direction.EAST);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.FALSE
                && messages.get("toyrobot.cant.move").equals(p.getErrorMessage()));
        Assert.assertEquals(new Integer(4),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(2),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.EAST,board.getRobot().getDirection());
    }

    @Test
    public void testMoveEast(){
        Robot robot = new Robot(3,1, Direction.EAST);
        board.setRobot(robot);

        CommandResponse response = move.execute();
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(4),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(1),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.EAST,board.getRobot().getDirection());
    }
}
