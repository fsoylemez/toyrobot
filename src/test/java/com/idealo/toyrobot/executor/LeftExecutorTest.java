package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.ToyRobotApplication;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.Direction;
import com.idealo.toyrobot.model.Robot;
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
public class LeftExecutorTest {

    @Autowired
    Board board;

    @Autowired
    LeftCommandExecutor left;


    @Test
    public void leftFromNorth(){
        Robot robot = new Robot(2,2, Direction.NORTH);
        board.setRobot(robot);
        left.execute();
        assertThat(board.getRobot()).isNotNull().matches(b->Direction.WEST.equals(b.getDirection()));
    }

    @Test
    public void leftFromEast(){
        Robot robot = new Robot(2,2, Direction.EAST);
        board.setRobot(robot);
        left.execute();
        assertThat(board.getRobot()).isNotNull().matches(b->Direction.NORTH.equals(b.getDirection()));
    }

    @Test
    public void leftFromSouth(){
        Robot robot = new Robot(2,2, Direction.SOUTH);
        board.setRobot(robot);
        left.execute();
        assertThat(board.getRobot()).isNotNull().matches(b->Direction.EAST.equals(b.getDirection()));
    }

    @Test
    public void leftFromWest(){
        Robot robot = new Robot(2,2, Direction.WEST);
        board.setRobot(robot);
        left.execute();
        assertThat(board.getRobot()).isNotNull().matches(b->Direction.SOUTH.equals(b.getDirection()));
    }
}
