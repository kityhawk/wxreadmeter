package com.whgas.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.whgas.model.Department;

@Repository
public interface DepartmentDao {
	
	public List<Department> getDeptByLocationId(@Param("locationId") int locationId);
}
