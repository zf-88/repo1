package com.bdqn.config.mapper;

import com.bdqn.config.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author zf
 * @create 2020-02-19 13:22
 */
@Mapper
@Repository
public interface EmpMapper {
    //增加一个员工
    //主键自增
    public  void save(Employee employee);



    //查询全部员工信息
    public Collection<Employee> getAll();



    //通过id查询员工
    public  Employee getEmployeeById(Integer id);
    //删除员工通过id
    public  void  deleteById(Integer id);
    //修改员工信息
    public  void update(Employee employee);

}
