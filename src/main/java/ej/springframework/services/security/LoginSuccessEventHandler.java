package ej.springframework.services.security;

import ej.springframework.domain.User;
import ej.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by eunsoojung on 1/24/17.
 * S14_L78_5.*
 */
@Component
public class LoginSuccessEventHandler implements ApplicationListener<LoginSuccessEvent> {
    // Inject user service
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        System.out.println("LoginEvent Failure for: " + authentication.getPrincipal());
        updateUserAccount(authentication);
    }

    public void updateUserAccount(Authentication authentication) {
        // Type cast
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUserName(userDetails.getUsername());

        if (user != null) {                         // user found
            user.setFailedLoginAttempts(0);

            System.out.println("Good login, resetting failed attempts.");
            userService.saveOrUpdate(user);
        }
    }
}
