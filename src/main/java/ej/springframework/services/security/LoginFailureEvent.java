package ej.springframework.services.security;

import org.springframework.context.ApplicationEvent;

/**
 * Created by EunsooJung on 1/23/17.
 * S14_L76_1.*
 */
public class LoginFailureEvent extends ApplicationEvent {

    public LoginFailureEvent(Object source) {
        super(source);
    }
}
