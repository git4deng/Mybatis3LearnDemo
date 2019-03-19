package com.david.mybatis.crud.dao;

import com.david.mybatis.crud.entities.Department;

public interface DepartmentMapper {
	public Department getDeptById(Integer id);
	//查询部门信息，并且查询部门下的所有员工信息
	public Department getDeptWithEmpsById(Integer id);
	//关联查询集合属性封装规则之二：分步查询
	public Department getDeptWithEmpsByIdStep(Integer id);
}
