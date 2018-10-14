package com.idealo.toyrobot.executor;

import com.idealo.toyrobot.ToyRobotApplication;
import com.idealo.toyrobot.messages.Messages;
import com.idealo.toyrobot.model.Board;
import com.idealo.toyrobot.model.CommandResponse;
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
public class ReportExecutorTest {

    @Autowired
    Board board;

    @Autowired
    Messages messages;

    @Autowired
    ReportCommandExecutor report;

    @Test
    public void testReportNoRobot(){
        CommandResponse response = report.execute();
        assertThat(response).isNotNull().matches(r->r.getSuccess()==Boolean.FALSE &&
                r.getErrorMessage().equals(messages.get("toyrobot.no.robot")) && r.getOutcome()==null);
    }

    @Test
    public void testReportRobot(){
        Robot robot = new Robot(2,2, Direction.NORTH);
        board.setRobot(robot);
        CommandResponse response = report.execute();
        assertThat(response).isNotNull().matches(r->r.getSuccess()==Boolean.TRUE &&
        r.getErrorMessage()==null && r.getOutcome().equals("2,2,NORTH"));
    }
}
