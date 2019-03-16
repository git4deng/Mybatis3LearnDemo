package com.david.mybatis.test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.david.mybatis.dao.EmployeeMapper;
import com.david.mybatis.dao.EmployeeMapperAnnotation;
import com.david.mybatis.entities.Employee;

public class HelloTest {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	
	/**
	 * ��ʼ��sqlSessionFactory�����session
	 * @throws IOException
	 */
	@Before
	public void init() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}
	@After
	public void destroy(){
		session.close();
	}
	/**
	 * 1������xml�����ļ���ȫ�������ļ�������һ��SqlSessionFactory���� ������ԴһЩ���л�����Ϣ
	 * 2��sqlӳ���ļ���������ÿһ��sql���Լ�sql�ķ�װ����ȡ� 
	 * 3����sqlӳ���ļ�ע����ȫ�������ļ���
	 * 4��д���룺
	 * 		1��������ȫ�������ļ��õ�SqlSessionFactory��
	 * 		2����ʹ��sqlSession��������ȡ��sqlSession����ʹ������ִ����ɾ�Ĳ�
	 * 			һ��sqlSession���Ǵ�������ݿ��һ�λỰ������ر�
	 * 		3����ʹ��sql��Ψһ��־������MyBatisִ���ĸ�sql��sql���Ǳ�����sqlӳ���ļ��еġ�
	 * 
	 * @throws IOException
	 */
	/**
	 * ���淽ʽ��ȡʵ��
	 */
	@Test
	public void testGetEmployeeById() {
		Employee employee = session.selectOne("com.david.mybatis.entities.EmployeeMapper.selectEmp",1);
		System.out.println(employee);
	}
	/**
	 * 1���ӿ�ʽ���
	 * 	ԭ����		Dao		====>  DaoImpl
	 * 	mybatis��	Mapper	====>  xxMapper.xml
	 * 
	 * 2��SqlSession��������ݿ��һ�λỰ���������رգ�
	 * 3��SqlSession��connectionһ�������Ƿ��̰߳�ȫ��ÿ��ʹ�ö�Ӧ��ȥ��ȡ�µĶ���
	 * 4��mapper�ӿ�û��ʵ���࣬����mybatis��Ϊ����ӿ�����һ���������
	 * 		�����ӿں�xml���а󶨣�
	 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
	 * 5��������Ҫ�������ļ���
	 * 		mybatis��ȫ�������ļ����������ݿ����ӳ���Ϣ�������������Ϣ��...ϵͳ���л�����Ϣ
	 * 		sqlӳ���ļ���������ÿһ��sql����ӳ����Ϣ��
	 * 					��sql��ȡ������	
	 */
	@Test
	public void testGetByInterface(){
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		//mapper�Ǹýӿڵ�һ��������
		System.out.println(mapper);
		Employee employee = mapper.getEmployeeById(1);
		System.out.println(employee);
	}
	@Test
	public void testGetByAnnotation(){
		EmployeeMapperAnnotation mapper = session.getMapper(EmployeeMapperAnnotation.class);
		//mapper�Ǹýӿڵ�һ��������
		System.out.println(mapper);
		Employee employee = mapper.getEmployeeById(1);
		System.out.println(employee);
	}
}
