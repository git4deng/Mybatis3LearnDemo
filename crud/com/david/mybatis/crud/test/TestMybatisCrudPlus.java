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
	 * ��ʼ��sqlSessionFactory�����session
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
	 * ����resultMapָ�������¼��ӦJavaBean�ķ�װ����
	 */
	@Test
	public void getEmpByIdTest(){
		Employee emp = mapper.getEmpById(6);
		System.out.println(emp);
	}
	/**
	 * ������ѯ��resultMap��װ�������ò��ԣ����ü������Եķ�ʽ��ʹ��association��ǩ�����������ķ�ʽ
	 */
	@Test
	public void getEmpAndDeptByIdTest(){
		Employee emp = mapper.getEmpAndDeptById(6);
		System.out.println(emp);
	}
	/**
	 * ������ѯ��resultMap��װ�������ò��ԣ�ʹ��association��ǩ����ֲ���ѯӳ�����,
	 * �ֲ���ѯ����ʹ���ӳټ��أ�ֻ����ȫ�������ļ�������2�����ԣ�
	 * <setting name="lazyLoadingEnabled" value="true"/>
	 * <setting name="aggressiveLazyLoading" value="false"/>
	 * �Ϳ��Դﵽ dept����Ҫ��ʱ��Ų�ѯ��Ч��,��ֻ�ᷢ��һ��sql
	 */
	@Test
	public void getEmpByIdStepTest(){
		Employee emp = mapper.getEmpByIdStep(6);
		System.out.println(emp.getLastName());
		//ʹ��dept����Żᷢ�Ͳ�ѯdept�����sql
		System.out.println(emp.getDept());
	}
}