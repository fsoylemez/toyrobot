package com.idealo.toyrobot.messages;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class Messages {

    private final MessageSourceAccessor accessor;

    public Messages(MessageSource messageSource) {
        this.accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }

}

