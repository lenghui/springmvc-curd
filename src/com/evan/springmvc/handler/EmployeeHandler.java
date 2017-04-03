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

	// ȡ����̬������еĶ���ͨ��map��Ų���ʾ��ҳ����
	@RequestMapping("/listEmp")
	public String listEmp(Map<String, Object> map) {
		map.put("employees", employeedao.getEmployees());
		return "list";
	}

	// ��ȡinput����,����departments��Map����
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("departments", departmentDao.getDepartments());
		return "put";
	}

	// ��putҳ���ϵ�employee���󱣴浽��̬������У�������ת����listEmp
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String Save(Employee employee) {
		employeedao.save(employee);
		System.out.println(employee.toString());
		return "redirect:/listEmp";
	}

	// ����uri������idֵɾ�����ݣ�������ת����listEmp
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		employeedao.delete(id);
		return "redirect:/listEmp";
	}

	// ���ݴ����Ա��IDֵ�޸�Ա����Ϣ��ʵ�ֱ�����
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Map<String, Object> map) {
		System.out.println("update,�Ƿ���idֵ:" + id);
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
