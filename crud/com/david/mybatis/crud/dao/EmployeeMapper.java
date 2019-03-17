package com.david.mybatis.crud.dao;

import org.apache.ibatis.annotations.Param;

import com.david.mybatis.crud.entities.Employee;

public interface EmployeeMapper {
	public Employee getEmployeeById(Integer id);
	public void addEmp(Employee emp);
	public int addEmployee(Employee emp);
	public void updateEmp(Employee emp);
	public void deleteEmpById(Integer id);
	/*
	 * 多个参数：mybatis会做特殊处理，多个参数会被封装成 一个map，key的默认取值是param1...paramN,这种使用起来很麻烦，
	 * 可以使用@Param注解指定key值，这样在mapper配置文件直接拿Param标记对应的value即可
	 */
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
}
