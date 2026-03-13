package com.aruna.controller;

import com.aruna.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ExampleController {

    private static final Logger log = LoggerFactory.getLogger(ExampleController.class);

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }


    @GetMapping("hello")
    public ResponseEntity<String> getString() {
       log.info("Received request from ui::");
       return ResponseEntity.ok(exampleService.sayHello());
    }
}
