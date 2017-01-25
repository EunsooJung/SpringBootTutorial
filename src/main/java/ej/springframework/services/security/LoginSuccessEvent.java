package ej.springframework.services.security;

import org.springframework.context.ApplicationEvent;

/**
 * Created by eunsoojung on 1/24/17.
 */
public class LoginSuccessEvent extends ApplicationEvent {

    public LoginSuccessEvent(Object source) {
        super(source);
    }
}
