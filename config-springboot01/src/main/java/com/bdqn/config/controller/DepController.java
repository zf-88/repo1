package com.bdqn.config.controller;

import com.bdqn.config.entity.Department;
import com.bdqn.config.service.DepService;
import com.bdqn.config.service.imp.DepServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zf
 * @create 2020-02-19 13:51
 */
@RestController
public class DepController {
    @Autowired
    private DepServiceImp depServiceImp;

    @GetMapping("/getAllDep")
    public List<Department> getAllDep(){

        return depServiceImp.getDepartments();
    }
}
