package com.std.service;

import java.util.List;
import java.util.Map;

import com.std.bean.Employee;

public interface EmployeeServices {
	
	public String insert(Employee emp);
	
	public Integer delete(int id);
	
	public Integer update(Employee employee);
	
	public List<Employee> findAll();
	
	public Employee findEmployee(int id);
	public List<Map<String, Object>> login(Employee emp);
}
