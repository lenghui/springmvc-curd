package com.evan.springmvc.dao;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evan.springmvc.entity.Department;
import com.evan.springmvc.entity.Employee;

@Repository
public class EmployeeDao {

	private static HashMap<Integer, Employee> employees = null;
	private static int INITID = 1006;
	@Autowired
	private DepartmentDao departmentDao;
	static {

		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));

	}

	public Collection<Employee> getEmployees() {
		return employees.values();
	}

	public Employee getEmployee(int id) {
		return employees.get(id);
	}

	public void save(Employee employee) {
		if (employee.getId() == 0) {
			employee.setId(INITID++);
		}

		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	public void delete(int id) {
		employees.remove(id);
	}
}
