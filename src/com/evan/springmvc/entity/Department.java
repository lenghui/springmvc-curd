package com.evan.springmvc.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Department {
	private int id;
	private String departmentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department(int id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
	}

}
