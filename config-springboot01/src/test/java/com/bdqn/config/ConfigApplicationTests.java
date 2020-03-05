package com.bdqn.config;

import com.bdqn.config.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigApplicationTests {
@Autowired
    private Student student;

    @Test
    void contextLoads() {

System.out.println(student.toString());


    }

}
