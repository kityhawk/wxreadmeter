package com.whgas.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.whgas.model.Departments;

@Repository
public interface DepartmentDao {
	
	public List<Departments> getDeptByLocationId(@Param("locationId") int locationId);
}
