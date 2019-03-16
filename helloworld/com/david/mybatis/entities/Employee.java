package com.david.mybatis.entities;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * entity
 * @author david
 *
 */
//@Alias("emp") //可以使用Alias配置java的别名
public class Employee implements Serializable {

	private static final long serialVersionUID = -6728642952466653736L;
	private Integer id;
	private String lastName;
	private String email;
	private String gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + "]";
	}

}
