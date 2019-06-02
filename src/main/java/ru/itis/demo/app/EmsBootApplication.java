package ru.itis.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.Predicate;

@SpringBootApplication
@ComponentScan(basePackages = "ru.itis.demo")
@EnableJpaRepositories(basePackages = "ru.itis.demo.repositories")
@EntityScan(basePackages = "ru.itis.demo.models")
public class EmsBootApplication {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(
                EmsBootApplication.class, args);
    }

}
