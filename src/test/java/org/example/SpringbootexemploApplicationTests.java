package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Teste minimo: sobe o contexto do Spring inteiro. Se algum bean estiver
 * mal configurado, ele falha aqui. Rode com "mvn test".
 */
@SpringBootTest
class SpringbootexemploApplicationTests {

    @Test
    void contextLoads() {
    }
}
