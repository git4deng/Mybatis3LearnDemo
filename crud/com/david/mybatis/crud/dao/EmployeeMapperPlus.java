package com.david.mybatis.crud.dao;

import java.util.List;

import com.david.mybatis.crud.entities.Employee;

public interface EmployeeMapperPlus {
	//�������ѯ��resultMapӳ���������
	public Employee getEmpById(Integer id);
	//������ѯ��resultMapӳ���������
	public Employee getEmpAndDeptById(Integer id);
	//������ѯ��resultMap�ֲ���ѯ
	public Employee getEmpByIdStep(Integer id);
	public List<Employee> getEmpsByDid(Integer id);
	
}
