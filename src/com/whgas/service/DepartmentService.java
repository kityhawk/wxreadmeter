package com.whgas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whgas.config.MultipleDataSource;
import com.whgas.dao.DepartmentDao;
import com.whgas.model.Department;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public List<Department> getDeptByLocationId( int locationId)
	{
		MultipleDataSource.setDataSourceKey("remoteDataSource");
		List<Department> deptlist = departmentDao.getDeptByLocationId(locationId);
		return deptlist;
	}
}
