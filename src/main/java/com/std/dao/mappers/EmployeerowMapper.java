package com.std.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.std.bean.Employee;

public class EmployeerowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee e=new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setDept(rs.getString(3));
		
		
		 return e;
	}

}
