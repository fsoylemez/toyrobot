package com.idealo.toyrobot.configuration;

import com.idealo.toyrobot.executor.PlaceCommandExecutor;
import com.idealo.toyrobot.model.Board;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;


@Configuration
@Profile(value = {"test"})
public class TestConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setCacheSeconds(3600); // Refresh cache once per hour.
        return source;
    }

    @Bean
    ServiceLocatorFactoryBean commandExecutorFactory() {
        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(CommandExecutorFactory.class);
        return bean;
    }

    @Bean
    @Scope(value = "singleton")
    Board myBoard() {
        return new Board();
    }

    @Bean
    PlaceCommandExecutor placeCommandExecutor() {
        return new PlaceCommandExecutor();
    }

}
