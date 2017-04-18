package com.spring.boot.unit.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.boot.unit.test.entity.Employee;
import com.spring.boot.unit.test.exceptions.NotFoundException;

@Controller
public class EmployeeController {
	
	private List<Employee> employees = new ArrayList<Employee>();

	@PostMapping("/employees")
	@ResponseBody
	public Employee postEmployee(@RequestBody Employee emp) {
		
		this.employees.add(emp);
		return emp;
	}
	
	public EmployeeController() {
		employees.add(new Employee("ali","male"));
	}

	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getMale(@RequestParam String gender) {

		return employees.stream().filter(g -> g.getGender()
				.equalsIgnoreCase(gender))
				.collect(Collectors.toList());

	}
	
	@GetMapping("/employees/{name}")
	@ResponseBody
	public List<Employee> findByName(@PathVariable String name){
		
		List<Employee> list = new ArrayList<Employee>();
		
		list = employees.stream()
				.filter(e -> e.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		
		if (list.size() == 0 || list.isEmpty())
			throw new NotFoundException();
		
		return employees;
	}

}
