package com.david.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.david.mybatis.entities.Employee;
/**
 * ����ע��ķ�ʽӳ��mapper
 * @author david
 *
 */
public interface EmployeeMapperAnnotation {
	@Select(" select * from david_employee where id = #{id}")
	public Employee getEmployeeById(Integer id);
}
