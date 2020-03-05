package com.bdqn.config.dao;

import com.bdqn.config.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zf
 * @create 2020-02-15 13:36
 */

public class DepartmetDao {
    private static Map<Integer, Department> departmentMap=null;
    static {
  departmentMap=new HashMap<Integer, Department>();
  departmentMap.put(101,new Department(101,"教学部"));
  departmentMap.put(102,new Department(102,"市场部"));
  departmentMap.put(103,new Department(103,"小卖部"));
  departmentMap.put(104,new Department(104,"后勤部"));
  departmentMap.put(105,new Department(105,"运营部"));


    }
    //得到所有部门信息
    public Collection<Department> getDepartments(){

    return  departmentMap.values();
    }

    //通过id得到部门
    public  Department getDepartmentById(int id){
        return departmentMap.get(id);
    }

}
