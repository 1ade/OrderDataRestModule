package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * Application configuration file. Used for bootstrap and data setup.
 * @author ifaturoti_adeyemi
 *
 */
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}