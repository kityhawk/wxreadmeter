package com.whgas.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.whgas.model.Employee;

@Repository
public interface EmployeeDao {
	
	public Employee getEmpById(@Param("empid") int empid);
	
	public List<Employee> getEmpsByDetpId(int deptId);
}
