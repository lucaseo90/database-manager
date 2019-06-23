package io.github.hsseo0501.databasemanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {

    @GetMapping(value = "/alive")
    ResponseEntity<?> get() {
        return ResponseEntity.ok("Database Manager alive");
    }

}
