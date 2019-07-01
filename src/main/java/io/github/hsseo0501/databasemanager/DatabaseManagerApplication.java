package io.github.hsseo0501.databasemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DatabaseManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseManagerApplication.class, args);
    }

}
