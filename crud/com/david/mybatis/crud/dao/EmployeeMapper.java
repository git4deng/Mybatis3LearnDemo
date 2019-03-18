package com.david.mybatis.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
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
	//��������Ҳû�ж�Ӧpojo��װ����ʹ��map��װ����
	public Employee getEmployeeByMap(Map<String,Object> params);
	//����list����
	public List<Employee> getEmpsByLastNameLike(String lastName);
	//һ�����ݷ���һ��map,key��������value���Ƕ�Ӧ��ȡֵ
	public Map<String,Object> getEmpByIdReturnMap(Integer id);
	//�������ݷ���һ��map��Map<Integer,Employee>,key��������¼��������ֵ�Ǽ�¼��װ���JavaBean
	@MapKey("id")//ָ���ĸ��ֶ���Ϊkey����map
	public Map<String,Employee> getEmpsByLastNameLikeReturnMap(String lastName);
}
