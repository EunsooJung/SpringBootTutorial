package ej.springframework.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * Created by eunsoojung on 1/27/17.
 */
// S16_L88_1.*
@EnableTransactionManagement
@Configuration
public class H2DataSourceConfig implements TransactionManagementConfigurer{

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    // S16_L88_1.5: Transaction Manager by Spring
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    // S16_L88_1.4
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}
