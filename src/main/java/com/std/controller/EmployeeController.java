package com.std.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.std.bean.Employee;
import com.std.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl eservices;
	
	
	// Handler method for Login Validation
	
	@RequestMapping(value = "/loginEmployee", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Employee employee) {

		List<Map<String, Object>> login = eservices.login(employee);

		if (login == null || login.isEmpty())
			return new ModelAndView("fail");
		else
			return new ModelAndView("success");
	}
	
	

	// Handler method for displaying new contact form

	@RequestMapping(value = "/newEmployee")
	public ModelAndView newEmployee(ModelAndView model) {
		Employee newEmployee = new Employee();
		model.addObject("employee", newEmployee);
		model.setViewName("registerform");
		return model;
	}

	// Handler method for inserting

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Employee employee) {

		eservices.insert(employee);
		return new ModelAndView("success");
	}

	// Handler method for Update

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		Integer update = eservices.update(employee);
		if (update != 0) {
			return new ModelAndView("deletesuccess");
		} else
			return new ModelAndView("fail");
	}

	// Handler method for deleting a contact:
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		int delete = eservices.delete(employeeId);
		if (delete != 0) {
			return new ModelAndView("deletesuccess");
		} else
			return new ModelAndView("fail");

	}

	// Handler method for listing all Employee's

	@RequestMapping(value = "/listEmployee")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		List<Employee> listEmployee = eservices.findAll();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("viewEmployee");

		return model;
	}

	public void setEservices(EmployeeServiceImpl eservices) {
		this.eservices = eservices;
	}

}
