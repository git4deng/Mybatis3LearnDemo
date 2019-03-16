package com.david.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.david.mybatis.entities.Employee;
/**
 * 基于注解的方式映射mapper
 * @author david
 *
 */
public interface EmployeeMapperAnnotation {
	@Select(" select * from david_employee where id = #{id}")
	public Employee getEmployeeById(Integer id);
}
