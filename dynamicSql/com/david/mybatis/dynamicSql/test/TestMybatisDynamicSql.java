package com.david.mybatis.dynamicSql.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.david.mybatis.dynamicSql.dao.EmployeeDynamicMapper;
import com.david.mybatis.dynamicSql.entities.Employee;

public class TestMybatisDynamicSql {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	private EmployeeDynamicMapper mapper;
	
	/**
	 * 初始化sqlSessionFactory对象和session
	 * @throws IOException
	 */
	@Before
	public void init() throws IOException{
		String resource = "mybatis-dynamic.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		mapper=session.getMapper(EmployeeDynamicMapper.class);
	}
	@After
	public void destroy(){
		session.commit();
		session.close();
	}
	/**
	 * 动态查询 if标签测试
	 */
	@Test
	public void getEmpsByConditionIfTest(){
		Employee emp =new Employee(6, "%java%", null, "1");
		List<Employee> emps = mapper.getEmpsByConditionIf(emp);
		System.out.println(emps);
	}
	/**
	 * 动态查询 trim标签测试
	 */
	@Test
	public void getEmpsByConditionTrimTest(){
		Employee emp =new Employee(null, null, null, "1");
		List<Employee> emps = mapper.getEmpsByConditionIf(emp);
		System.out.println(emps);
	}
	
}
