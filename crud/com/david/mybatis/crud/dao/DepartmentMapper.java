package com.david.mybatis.crud.dao;

import com.david.mybatis.crud.entities.Department;

public interface DepartmentMapper {
	public Department getDeptById(Integer id);
	//��ѯ������Ϣ�����Ҳ�ѯ�����µ�����Ա����Ϣ
	public Department getDeptWithEmpsById(Integer id);
}
