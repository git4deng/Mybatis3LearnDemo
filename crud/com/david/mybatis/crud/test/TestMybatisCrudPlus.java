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

import com.david.mybatis.crud.dao.DepartmentMapper;
import com.david.mybatis.crud.dao.EmployeeMapperPlus;
import com.david.mybatis.crud.entities.Department;
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
	/**
	 * 关联查询的resultMap封装规则设置测试，使用association标签定义分步查询映射规则,
	 * 分步查询可以使用延迟加载，只需在全局配置文件中配置2个属性：
	 * <setting name="lazyLoadingEnabled" value="true"/>
	 * <setting name="aggressiveLazyLoading" value="false"/>
	 * 就可以达到 dept在需要的时候才查询的效果,即只会发送一条sql
	 */
	@Test
	public void getEmpByIdStepTest(){
		Employee emp = mapper.getEmpByIdStep(6);
		System.out.println(emp.getLastName());
		//使用dept对象才会发送查询dept对象的sql
		System.out.println(emp.getDept());
		System.out.println(emp);
	}
	/**
	 * resultMap关联查询，collection集合属性定义封装规则之嵌套查询测试
	 */
	@Test
	public void getDeptWithEmpsByIdTest(){
		DepartmentMapper mapper=session.getMapper(DepartmentMapper.class);
		Department dept = mapper.getDeptWithEmpsById(1);
		System.out.println(dept);
	}
	/**
	 * resultMap关联查询，collection集合属性定义封装规则之分步查询测试
	 * 同样，懒加载机制一样适合集合属性的查询
	 */
	@Test
	public void getDeptWithEmpsByIdStepTest(){
		DepartmentMapper mapper=session.getMapper(DepartmentMapper.class);
		Department dept = mapper.getDeptWithEmpsByIdStep(1);
		System.out.println(dept.getDepartmentName());
		System.out.println(dept.getEmps());
	}
}
