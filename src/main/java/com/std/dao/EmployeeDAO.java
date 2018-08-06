package com.std.dao;

import java.util.List;
import java.util.Map;

import com.std.bean.Employee;

public interface EmployeeDAO {
	
	public int insert(Employee emp);
	
	
	
	public int delete(int id);
	
	public int update(Employee employee);
	
	public List<Employee> findAll();
	
	
	public Employee findEmployee(int id);
	public List<Map<String, Object>> login(Employee emp);
	
}
