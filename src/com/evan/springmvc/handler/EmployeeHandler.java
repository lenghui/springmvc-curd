package com.evan.springmvc.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evan.springmvc.dao.DepartmentDao;
import com.evan.springmvc.dao.EmployeeDao;
import com.evan.springmvc.entity.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeedao;

	@Autowired
	private DepartmentDao departmentDao;

	// 取出静态代码块中的对象，通过map存放并显示到页面中
	@RequestMapping("/listEmp")
	public String listEmp(Map<String, Object> map) {
		map.put("employees", employeedao.getEmployees());
		return "list";
	}

	// 调取input界面,存入departments的Map对象
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("departments", departmentDao.getDepartments());
		return "put";
	}

	// 将put页面上的employee对象保存到静态代码块中，并重新转发到listEmp
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String Save(Employee employee) {
		employeedao.save(employee);
		System.out.println(employee.toString());
		return "redirect:/listEmp";
	}

	// 根据uri传出来id值删除数据，并重新转发到listEmp
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		employeedao.delete(id);
		return "redirect:/listEmp";
	}

	// 根据传入的员工ID值修改员工信息，实现表单回显
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Map<String, Object> map) {
		System.out.println("update,是否有id值:" + id);
		map.put("employee", employeedao.getEmployee(id));
		map.put("departments", departmentDao.getDepartments());
		return "put";
	}

	int i = 1;

	@ModelAttribute("employee")
	public void addAttr(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		System.out.println(i);
		System.out.println("modelAttribute,id:" + id);
		if (id != null) {
			map.put("employee", employeedao.getEmployee(id));
		}
		i++;
	}

	/*
	 * @RequestMapping("/testHandler") public String testHandler(Map<String,
	 * Object> map) { map.put("hello", new String("hello")); return "list"; }
	 */
}
