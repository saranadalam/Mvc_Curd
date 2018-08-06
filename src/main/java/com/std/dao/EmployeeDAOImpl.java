package com.std.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.std.bean.Employee;
import com.std.dao.mappers.EmployeerowMapper;

public class EmployeeDAOImpl implements EmployeeDAO {

	JdbcTemplate jt;

	public int insert(Employee emp) {
		int rs = jt.update(
				"insert into employee values(" + emp.getId() + ",'" + emp.getName() + "','" + emp.getDept() + "')");
		return rs;
	}

	public int update(Employee employee) {

		String sql = "update employee set name='"+employee.getName()+"', dept='"+employee.getDept()+"' where id="+employee.getId();
		int n=jt.update(sql);
		return n;
	}

	public int delete(int id) {

		int n = jt.update("delete from employee where id=" + id);

		return n;
	}

	public Employee findEmployee(int id) {

		String findEmp = "select *from employee where id=?";

		Employee queryForObject = jt.queryForObject(findEmp, new Object[] { id }, new EmployeerowMapper());

		return queryForObject;
	}

	public List<Employee> findAll() {

		String sql = "select *from employee";
		List<Employee> elist = new ArrayList<Employee>();

		List<Map<String, Object>> queryForList = jt.queryForList(sql);
		for (Map row : queryForList) {
			Employee e = new Employee();
			e.setId((Integer) row.get("id"));
			e.setName((String) row.get("name"));
			e.setDept((String) row.get("dept"));

			elist.add(e);
		}
		return elist;
	}

	
	

public List<Map<String, Object>> login(Employee emp) {


		List<Map<String, Object>> queryForList = jt.queryForList("select *from employee where id="+emp.getId()+" and name='"+emp.getName()+"'");
		
		System.out.println(queryForList);
		return queryForList;

}
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	

}
