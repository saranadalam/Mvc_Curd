package com.std.service;

import java.util.List;
import java.util.Map;

import com.std.bean.Employee;
import com.std.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeServices {

	private EmployeeDAO dao;

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	public String insert(Employee emp) {

		int result = dao.insert(emp);
		if (result == 0)
			return emp.getId() + "Emp is not Registered";
		else
			return emp.getId() + "Emp is Registered";

	}

	public List<Employee> findAll() {

		List<Employee> emplist = dao.findAll();

		return emplist;
	}

	public Employee findEmployee(int id) {

		Employee findEmployee = dao.findEmployee(id);
		return findEmployee;
	}

	public Integer delete(int id) {

	int n=dao.delete(id);	
		return n;
	}

	public Integer update(Employee employee) {

		
		int n=dao.update(employee);
		
		return n;
	}

	
public List<Map<String, Object>> login(Employee emp) {

		
		return dao.login(emp);
	}
	

}
