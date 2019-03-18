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
	 * 多个参数：mybatis会做特殊处理，多个参数会被封装成 一个map，key的默认取值是param1...paramN,这种使用起来很麻烦，
	 * 可以使用@Param注解指定key值，这样在mapper配置文件直接拿Param标记对应的value即可
	 */
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	//参数过多也没有对应pojo封装可以使用map封装参数
	public Employee getEmployeeByMap(Map<String,Object> params);
	//返回list集合
	public List<Employee> getEmpsByLastNameLike(String lastName);
	//一条数据返回一个map,key是列名，value就是对应的取值
	public Map<String,Object> getEmpByIdReturnMap(Integer id);
	//多条数据返回一个map，Map<Integer,Employee>,key是这条记录的主键，值是记录封装后的JavaBean
	@MapKey("id")//指定哪个字段作为key存入map
	public Map<String,Employee> getEmpsByLastNameLikeReturnMap(String lastName);
}
