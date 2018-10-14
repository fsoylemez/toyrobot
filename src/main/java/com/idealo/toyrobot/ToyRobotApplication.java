package com.idealo.toyrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * ToyRobot application is a simple rest api
 * to manipulate a robot which is places on a 5 X 5 board
 * Valid commands are PLACE,LEFT,RIGHT,MOVE,REPORT
 *
 * @author  Fatih Soylemez
 * @version 1.0
 * @since   2018-10-14
 */
@SpringBootApplication
@ComponentScan("com.idealo.toyrobot")
@EnableAsync
public class ToyRobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyRobotApplication.class, args);
    }

}
