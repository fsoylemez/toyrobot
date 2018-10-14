package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.ToyRobotApplication;
import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.*;
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
public class PlaceExecutorTest {

    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Autowired
    PlaceCommandExecutor place;

    @Test
    public void testPlaceOutside(){
        board.setRobot(null);
        PlaceCommand placeCommand = new PlaceCommand(CommandType.PLACE, 5, 2, Direction.WEST);
        CommandResponse response = place.execute(placeCommand);

        Assert.assertEquals(null,board.getRobot());
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.FALSE
        && messages.get("toyrobot.cant.place").equals(p.getErrorMessage()));
    }

    @Test
    public void testPlace(){
        PlaceCommand placeCommand = new PlaceCommand(CommandType.PLACE, 0, 2, Direction.WEST);
        CommandResponse response = place.execute(placeCommand);

        Assert.assertNotNull(board.getRobot());
        assertThat(response).isNotNull().matches(p->p.getSuccess()==Boolean.TRUE);
        Assert.assertEquals(new Integer(0),board.getRobot().getxCoordinate());
        Assert.assertEquals(new Integer(2),board.getRobot().getyCoordinate());
        Assert.assertEquals(Direction.WEST,board.getRobot().getDirection());
    }
}
