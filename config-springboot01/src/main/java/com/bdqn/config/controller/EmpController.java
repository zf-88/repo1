package com.bdqn.config.controller;

import com.bdqn.config.dao.DepartmetDao;
import com.bdqn.config.dao.EmployeeDao;
import com.bdqn.config.entity.Department;
import com.bdqn.config.entity.Employee;
import com.bdqn.config.service.imp.DepServiceImp;
import com.bdqn.config.service.imp.EmpServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author zf
 * @create 2020-02-16 23:20
 */
@Controller
public class EmpController {
    @Autowired
    private EmpServiceImp empServiceImp;
    @Autowired
private DepServiceImp depServiceImp;
    @RequestMapping("/emps")
    public  String list(Model model){
            Collection<Employee> empList = empServiceImp.getAll();
         //   System.out.println(empList);
        model.addAttribute("emps",empList);

        return  "emp/list";



    }
    //跳转到add页面
    @GetMapping("/emp")
    public  String add(Model model){
//查出所有部门信息
        Collection<Department> departments = depServiceImp.getDepartments();
        model.addAttribute("dept",departments);

        return  "emp/add";



    }
    //增添员工
    @PostMapping("/emp")
    public  String addEmp(Employee employee){
    empServiceImp.save(employee);
        return  "redirect:/emps";
    }

    //跳转到update页面
    @GetMapping("/update/{id}")
    public  String updatePage(@PathVariable("id") Integer id,Model model){
        Employee employee = empServiceImp.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = depServiceImp.getDepartments();
        model.addAttribute("dept",departments);

        return  "emp/update";
    }
    //修改数据
    @PostMapping("/update")
    public String update(Employee employee){
      empServiceImp.update(employee);
        return  "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){

        empServiceImp.deleteById(id);
        return "redirect:/emps";
    }
}
