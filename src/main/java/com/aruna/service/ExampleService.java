package com.aruna.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ExampleService {

    private final RestTemplate restTemplate;

    @Value("${spring-ex2.api.url}")
    private String externalApiUrl;

    public ExampleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sayHello() {

        log.info("service say hello :::");
        log.debug("service say hello debug logs :::");
        log.warn("service say hello warn logs :::");
        try {

            return restTemplate.getForObject(externalApiUrl, String.class);
        }catch (Exception e){
            log.error("error external api call : {}" , e.fillInStackTrace());
        }

        return null;
    }
}
