package com.david.mybatis.crud.dao;

import com.david.mybatis.crud.entities.Employee;

public interface EmployeeMapper {
	public Employee getEmployeeById(Integer id);
	public void addEmp(Employee emp);
	public int addEmployee(Employee emp);
	public void updateEmp(Employee emp);
	public void deleteEmpById(Integer id);
}
