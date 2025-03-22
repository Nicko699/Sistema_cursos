package org.sistema_cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication

public class SistemaCursosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaCursosApplication.class, args);
    }

}
