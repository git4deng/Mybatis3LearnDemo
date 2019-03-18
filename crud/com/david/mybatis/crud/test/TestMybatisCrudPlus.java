package com.david.mybatis.crud.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.david.mybatis.crud.dao.EmployeeMapper;
import com.david.mybatis.crud.dao.EmployeeMapperPlus;
import com.david.mybatis.crud.entities.Employee;

public class TestMybatisCrudPlus {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	private EmployeeMapperPlus mapper;
	
	/**
	 * 初始化sqlSessionFactory对象和session
	 * @throws IOException
	 */
	@Before
	public void init() throws IOException{
		String resource = "mybatis-crud.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		mapper=session.getMapper(EmployeeMapperPlus.class);
	}
	@After
	public void destroy(){
		session.commit();
		session.close();
	}
	/**
	 * 测试resultMap指定查出记录对应JavaBean的封装规则
	 */
	@Test
	public void getEmpByIdTest(){
		Employee emp = mapper.getEmpById(6);
		System.out.println(emp);
	}
	/**
	 * 关联查询的resultMap封装规则设置测试，采用级联属性的方式和使用association标签定义关联对象的方式
	 */
	@Test
	public void getEmpAndDeptByIdTest(){
		Employee emp = mapper.getEmpAndDeptById(6);
		System.out.println(emp);
	}
}
