package com.example.pars;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ParsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ParsApplication.class, args);
        Pars.pars();
    }

}
