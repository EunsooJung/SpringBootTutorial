package ej.springframework.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by eunsoojung on 9/6/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("ej.springframework")
@ActiveProfiles("jpadao")
public class JpaIntegrationConfig {
}
