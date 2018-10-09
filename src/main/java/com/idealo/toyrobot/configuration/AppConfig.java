package com.idealo.toyrobot.configuration;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile( value = { "development" } )
public class AppConfig {

    @Bean
    ServiceLocatorFactoryBean myExecutor() {
        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(CommandExecutorFactory.class);
        return bean;
    }

}
