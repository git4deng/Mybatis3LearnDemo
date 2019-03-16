package com.david.mybatis.dao;

import com.david.mybatis.entities.Employee;

public interface EmployeeMapper {
	public Employee getEmployeeById(Integer id);
}
