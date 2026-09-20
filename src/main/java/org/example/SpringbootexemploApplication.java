package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ponto de entrada da aplicacao.
 *
 * A anotacao @SpringBootApplication faz tres coisas de uma vez:
 *  - marca esta classe como fonte de configuracao do Spring;
 *  - liga a auto-configuracao (o Spring olha o que voce tem no classpath
 *    e configura sozinho: como tem spring-boot-starter-web, ele sobe o Tomcat);
 *  - varre ESTE pacote (org.example) e os subpacotes procurando seus
 *    componentes, como o OlaController.
 */
@SpringBootApplication
public class SpringbootexemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootexemploApplication.class, args);
    }
}
