package com.idealo.toyrobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("com.idealo.toyrobot")
@EnableAsync
public class ToyRobotApplication {

    public static void main(String[] args) {          
        SpringApplication.run(ToyRobotApplication.class, args);
    }

}
