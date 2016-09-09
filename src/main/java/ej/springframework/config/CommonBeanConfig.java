package ej.springframework.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by eunsoojung on 9/7/16.
 */
@Configuration
public class CommonBeanConfig {

    @Bean
    public StrongPasswordEncryptor strongPasswordEncryptor() {
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        return encryptor;
    }
}