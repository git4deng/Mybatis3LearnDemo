package com.david.mybatis.crud.dao;

import com.david.mybatis.crud.entities.Employee;

public interface EmployeeMapperPlus {
	//单个表查询的resultMap映射规则配置
	public Employee getEmpById(Integer id);
	//关联查询的resultMap映射规则配置
	public Employee getEmpAndDeptById(Integer id);
	
}
