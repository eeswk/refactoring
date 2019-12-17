package com.swan.ee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RefactoringApplication {

    public static void main(String[] args) {
        //웹구동 제외
        new SpringApplicationBuilder(RefactoringApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
//        SpringApplication.run(RefactoringApplication.class, args);
    }

}
