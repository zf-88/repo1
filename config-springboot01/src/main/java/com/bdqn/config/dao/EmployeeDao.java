package com.bdqn.config.dao;

import com.bdqn.config.entity.Department;
import com.bdqn.config.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zf
 * @create 2020-02-15 13:36
 */

public class EmployeeDao {
//模拟数据库中的数据
private static Map<Integer, Employee> employeeMap=null;
@Autowired
private  DepartmetDao departmetDao;
    static {
        employeeMap=new HashMap<Integer, Employee>();
        employeeMap.put(1001,new Employee(1001,"aa","a44900395@qq.com",1,new Department(101,"教学部") ,new Date()));
        employeeMap.put(1002,new Employee(1002,"bb","b44900395@qq.com",0,new Department(102,"市场部") ,new Date()));
        employeeMap.put(1003,new Employee(1003,"cc","c44900395@qq.com",1,new Department(103,"小卖部") ,new Date()));
        employeeMap.put(1004,new Employee(1004,"dd","d44900395@qq.com",0,new Department(104,"后勤部") ,new Date()));
        employeeMap.put(1005,new Employee(1005,"ee","e44900395@qq.com",1,new Department(105,"运营部") ,new Date()));
       // employeeMap.put(1005,new Employee(1005,"qq","e44900395@qq.com",1,new Department(105,"运营部") ,new Date()));
    }

    //增加一个员工
    //主键自增
    private  Integer init=1006;
    public  void save(Employee employee){
  if(employee.getId()==null){
      employee.setId(init++);

  }
  employee.setDepartment(departmetDao.getDepartmentById(employee.getDepartment().getId()));
employeeMap.put(employee.getId(),employee);
    }


    //查询全部员工信息
    public Collection<Employee> getAll(){

        return employeeMap.values();
    }

    //通过id查询员工
    public  Employee getEmployeeById(Integer id){
        return  employeeMap.get(id);
    }
//删除员工通过id
    public  void  deleteById(Integer id){

        employeeMap.remove(id);
    }


}
