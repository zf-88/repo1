package com.bdqn.config.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

/**
 * @author zf
 * @create 2020-02-14 12:56
 */
@Component
@ConfigurationProperties(prefix = "student")
//@PropertySource(value = "classpath:zhoufan.properties") 指定一个配置文件
//如果是properties文件  只能单个赋值@Value("${name}")
@Validated
//开启校验数据 JSR303
public class Student {

   // @Email(message = "不是一个邮箱格式！！")
    private  String name;
    private  int age;
    private Map<?,?> map;
    private List list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<?, ?> getMap() {
        return map;
    }

    public void setMap(Map<?, ?> map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Student() {

    }

    public Student(String name, int age, Map<?, ?> map, List list) {
        this.name = name;
        this.age = age;
        this.map = map;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", map=" + map +
                ", list=" + list +
                '}';
    }
}
