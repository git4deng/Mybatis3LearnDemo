package com.david.mybatis.crud.dao;

import com.david.mybatis.crud.entities.Employee;

public interface EmployeeMapperPlus {
	//�������ѯ��resultMapӳ���������
	public Employee getEmpById(Integer id);
	//������ѯ��resultMapӳ���������
	public Employee getEmpAndDeptById(Integer id);
	
}
