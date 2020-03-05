package com.bdqn.config.service.imp;

import com.bdqn.config.entity.Employee;
import com.bdqn.config.mapper.EmpMapper;
import com.bdqn.config.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author zf
 * @create 2020-02-19 14:25
 */
@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    EmpMapper empMapper;
    @Override
    public void save(Employee employee) {
        empMapper.save(employee);
    }

    @Override
    public Collection<Employee> getAll() {
        return empMapper.getAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return empMapper.getEmployeeById(id);
    }

    @Override
    public void deleteById(Integer id) {
     empMapper.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        empMapper.update(employee);
    }
}
