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
	 * ���������mybatis�������⴦����������ᱻ��װ�� һ��map��key��Ĭ��ȡֵ��param1...paramN,����ʹ���������鷳��
	 * ����ʹ��@Paramע��ָ��keyֵ��������mapper�����ļ�ֱ����Param��Ƕ�Ӧ��value����
	 */
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
}
