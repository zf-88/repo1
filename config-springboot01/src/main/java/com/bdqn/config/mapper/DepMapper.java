package com.bdqn.config.mapper;

import com.bdqn.config.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author zf
 * @create 2020-02-19 13:21
 */
@Mapper
@Repository
public interface DepMapper {
    //得到所有部门信息
    public List<Department> getDepartments();

    //通过id得到部门
    public  Department getDepartmentById(Integer id);
}
