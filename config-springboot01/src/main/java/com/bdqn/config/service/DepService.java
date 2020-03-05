package com.bdqn.config.service;

import com.bdqn.config.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zf
 * @create 2020-02-19 13:45
 */

public interface DepService {
    //得到所有部门信息
    public List<Department> getDepartments();

    //通过id得到部门
    public  Department getDepartmentById(Integer id);
}
