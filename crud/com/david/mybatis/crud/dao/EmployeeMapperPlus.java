package com.david.mybatis.crud.dao;

import java.util.List;

import com.david.mybatis.crud.entities.Employee;

public interface EmployeeMapperPlus {
	//单个表查询的resultMap映射规则配置
	public Employee getEmpById(Integer id);
	//关联查询的resultMap映射规则配置
	public Employee getEmpAndDeptById(Integer id);
	//关联查询的resultMap分步查询
	public Employee getEmpByIdStep(Integer id);
	public List<Employee> getEmpsByDid(Integer id);
	
}
