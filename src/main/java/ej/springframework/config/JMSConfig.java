package ej.springframework.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Created by eunsoojung on 4/10/17.
 */
@Configuration
public class JMSConfig {

    public static final String textMsgQueue = "text.messagequeue";

    @Bean
    public Queue textMessageQueue() {
        return new ActiveMQQueue(textMsgQueue);
    }
}

