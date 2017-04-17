package com.spring.boot.unit.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.unit.test.entity.Employee;

@Controller
public class EmployeeController {
	Employee[] e = new Employee[] { new Employee("ali", "male"), new Employee("siti", "female") };

	@PostMapping("/employees")
	@ResponseBody
	public Employee getAll(@RequestBody Employee emp) {

		return emp;
	}

	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getMale(@RequestParam String gender) {
		List<Employee> listEmployees = Arrays.asList(e);

		listEmployees = listEmployees.stream().filter(g -> g.getGender().equalsIgnoreCase(gender))
				.collect(Collectors.toList());

		return listEmployees;

	}

}
