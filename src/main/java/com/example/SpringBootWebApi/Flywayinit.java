package com.example.SpringBootWebApi;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
@Component
public class Flywayinit {
    @Value("${flyway.script.location}")
    private String flywayLocation;

    @Autowired
    private DataSource dataSource;


    @PostConstruct
    public void afterPropertiesSet() throws Exception {

        Flyway flyway = Flyway.configure().locations(flywayLocation).
                dataSource(dataSource).load();
        flyway.repair();
        flyway.migrate();
    }
}
