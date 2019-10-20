package com.goodjob.bscs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.goodjob.bscs.soi.ConnectionPoolManager;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public ConnectionPoolManager soiConnectionPoolManager() throws Exception {
    	return new ConnectionPoolManager();
    }
}
