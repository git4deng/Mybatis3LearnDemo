package com.david.mybatis.dynamicSql.dao;

import java.util.List;

import com.david.mybatis.dynamicSql.entities.Employee;

public interface EmployeeDynamicMapper {
	public List<Employee> getEmpsByConditionIf(Employee emp);
	public List<Employee> getEmpsByConditionTrim(Employee emp);
	public List<Employee> getEmpsByConditionChoose(Employee emp);
	public void updateEmployeeBySet(Employee emp);
}
