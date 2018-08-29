package com.whgas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whgas.model.Departments;
import com.whgas.service.DepartmentService;
import com.whgas.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    DepartmentService departmentService;
    
    @RequestMapping("/getname")
    @ResponseBody
    public String getname(HttpServletRequest request)
    {
    	String name = employeeService.getEmpNameById(112);
    	return employeeService.getCustLIstByOrgId(100).get(0).getFirst_name()+name;
    }
    
    @RequestMapping("/getDeptList")
    @ResponseBody
    public String getDeptList(HttpServletRequest request)
    {
    	List<Departments> deptlist = departmentService.getDeptByLocationId(1700);
    	return deptlist.get(0).getDepartment_name();
    }
    
    @RequestMapping("/sui")
    public String getSui()
    {
    	return "sui";
    }
}
