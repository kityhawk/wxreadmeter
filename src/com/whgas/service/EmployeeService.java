package com.whgas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whgas.config.MultipleDataSource;
import com.whgas.dao.DepartmentDao;
import com.whgas.dao.EmployeeDao;
import com.whgas.model.Departments;
import com.whgas.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public String getEmpNameById(int empId)
	{	
		MultipleDataSource.setDataSourceKey("localDataSource");
		String returnString = "";
		Employee emp = employeeDao.getEmpById(empId);
		returnString = emp.getFirst_name()+"-"+emp.getLast_name();
		
		MultipleDataSource.setDataSourceKey("remoteDataSource");
		List<Departments> deptlist = departmentDao.getDeptByLocationId(1700);
		returnString = returnString+"|"+deptlist.get(0).getDepartment_name();
		
		MultipleDataSource.setDataSourceKey("localDataSource");
		emp = employeeDao.getEmpById(empId);
		returnString = returnString+"|"+emp.getFirst_name();
		return returnString;
	}
	
	public List<Employee> getCustLIstByOrgId(int deptId)
	{
		List<Employee> emplist = employeeDao.getEmpsByDetpId(deptId);
		return emplist;
	}
}
