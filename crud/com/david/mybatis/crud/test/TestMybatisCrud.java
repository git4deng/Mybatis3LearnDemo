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
	 * ��ʼ��sqlSessionFactory�����session
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
	 * ������ɾ��
	 * 1��mybatis������ɾ��ֱ�Ӷ����������ͷ���ֵ
	 * 		Integer��Long��Boolean��void
	 * 2��������Ҫ�ֶ��ύ����
	 * 		sqlSessionFactory.openSession();===���ֶ��ύ
	 * 		sqlSessionFactory.openSession(true);===���Զ��ύ
	 * @throws IOException 
	 */
	
	@Test
	public void testSave() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee emp = new Employee(null,"java", "java@java.com", "1");
		mapper.addEmp(emp);
		System.out.println("Ա����id:"+emp.getId());
	}
	@Test
	public void testSaveReturn() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		int n = mapper.addEmployee(new Employee(null,"java", "java@java.com", "1"));
		System.out.println("����Ա��"+(n==1?"":"��")+"�ɹ���");
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
	 * ��������������
	 */
	@Test
	public void testGetEmployeeByIdAndLastName() {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee emp = mapper.getEmployeeByIdAndLastName(8, "java");
		System.out.println(emp);
	}
}
