package com.bdqn.config.service.imp;

import com.bdqn.config.entity.Department;
import com.bdqn.config.mapper.DepMapper;
import com.bdqn.config.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zf
 * @create 2020-02-19 13:46
 */

@Service
public class DepServiceImp implements DepService {
    @Autowired
    private DepMapper depMapper;
    @Override
    public List<Department> getDepartments() {
        return depMapper.getDepartments();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return depMapper.getDepartmentById(id);
    }
}
