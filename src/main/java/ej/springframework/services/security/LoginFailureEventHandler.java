package ej.springframework.services.security;

import ej.springframework.domain.User;
import ej.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by eunsoojung on 1/23/17.
 *
 * // De-couple Spring application...
 * S14_L76_3.*
 */
@Component
public class LoginFailureEventHandler implements ApplicationListener<LoginFailureEvent> {

    // S14_L77_2
    private UserService userService;
    // S14_L77_2
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(LoginFailureEvent event) {

        Authentication authentication = (Authentication) event.getSource();
        System.out.println("LoginEvent Failure for: " + authentication.getPrincipal());

        // S14_L77_3
        updateUserAccount(authentication);

    }

    // S14_L77_3.2
    public void updateUserAccount(Authentication authentication) {
        User user = userService.findByUserName((String) authentication.getPrincipal());

        if (user != null)   // user found
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);

            if (user.getFailedLoginAttempts() > 5) {
                user.setEnabled(false);
            }

            System.out.println("Valid User name, updating failed attempts");
            userService.saveOrUpdate(user);
    }
}
