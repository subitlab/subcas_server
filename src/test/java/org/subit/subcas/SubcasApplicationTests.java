package org.subit.subcas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class SubcasApplicationTests {


    @Resource
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String password = "123456";
        System.out.println(passwordEncoder.encode(password));
    }

}
