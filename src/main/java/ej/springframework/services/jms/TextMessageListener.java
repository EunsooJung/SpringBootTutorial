package ej.springframework.services.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by eunsoojung on 4/17/17.
 * S17_L93
 */
@Component
public class TextMessageListener {

    @JmsListener(destination = "text.messagequeue")
    public void onMessage(String msg) {
        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("I GOT A MESSAGE");
        System.out.println(msg);
        System.out.println("###############################");
        System.out.println("###############################");

    }
}
