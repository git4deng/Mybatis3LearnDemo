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
	 * 初始化sqlSessionFactory对象和session
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
	 * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
	 * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。 
	 * 3、将sql映射文件注册在全局配置文件中
	 * 4、写代码：
	 * 		1）、根据全局配置文件得到SqlSessionFactory；
	 * 		2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
	 * 			一个sqlSession就是代表和数据库的一次会话，用完关闭
	 * 		3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
	 * 
	 * @throws IOException
	 */
	/**
	 * 常规方式获取实体
	 */
	@Test
	public void testGetEmployeeById() {
		Employee employee = session.selectOne("com.david.mybatis.entities.EmployeeMapper.selectEmp",1);
		System.out.println(employee);
	}
	/**
	 * 1、接口式编程
	 * 	原生：		Dao		====>  DaoImpl
	 * 	mybatis：	Mapper	====>  xxMapper.xml
	 * 
	 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
	 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
	 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
	 * 		（将接口和xml进行绑定）
	 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
	 * 5、两个重要的配置文件：
	 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
	 * 		sql映射文件：保存了每一个sql语句的映射信息：
	 * 					将sql抽取出来。	
	 */
	@Test
	public void testGetByInterface(){
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		//mapper是该接口的一个代理类
		System.out.println(mapper);
		Employee employee = mapper.getEmployeeById(1);
		System.out.println(employee);
	}
	@Test
	public void testGetByAnnotation(){
		EmployeeMapperAnnotation mapper = session.getMapper(EmployeeMapperAnnotation.class);
		//mapper是该接口的一个代理类
		System.out.println(mapper);
		Employee employee = mapper.getEmployeeById(1);
		System.out.println(employee);
	}
}
