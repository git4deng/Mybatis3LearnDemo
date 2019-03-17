package com.david.mybatis.crud.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.david.mybatis.crud.dao.EmployeeMapper;
import com.david.mybatis.crud.entities.Employee;

public class TestMybatisCrud {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	
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
	}
	@After
	public void destroy(){
		session.commit();
		session.close();
	}
	/**
	 * 测试增删改
	 * 1、mybatis允许增删改直接定义以下类型返回值
	 * 		Integer、Long、Boolean、void
	 * 2、我们需要手动提交数据
	 * 		sqlSessionFactory.openSession();===》手动提交
	 * 		sqlSessionFactory.openSession(true);===》自动提交
	 * @throws IOException 
	 */
	
	@Test
	public void testSave() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee emp = new Employee(null,"java", "java@java.com", "1");
		mapper.addEmp(emp);
		System.out.println("员工的id:"+emp.getId());
	}
	@Test
	public void testSaveReturn() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		int n = mapper.addEmployee(new Employee(null,"java", "java@java.com", "1"));
		System.out.println("保存员工"+(n==1?"":"不")+"成功！");
	}
	@Test
	public void testUpdate() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		mapper.updateEmp(new Employee(5,"php", "php@java.com", "0"));
	}
	@Test
	public void testDelete() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		mapper.deleteEmpById(5);
	}
	/**
	 * 多个参数处理测试
	 */
	@Test
	public void testGetEmployeeByIdAndLastName() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee emp = mapper.getEmployeeByIdAndLastName(8, "java");
		System.out.println(emp);
	}
}
