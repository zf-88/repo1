package com.bdqn.config.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zf
 * @create 2020-02-15 12:18
 */
//员工表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private  String lastName;
    private  String email;
    private Integer gender;//0:女 1：男
    private  Department department;
    private Date birth;
}
