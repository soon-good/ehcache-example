package io.study.ehcache.employee;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAllEmployees();
	}

	@GetMapping("/employee/{name}")
	public Employee getEmployeeByName(@PathVariable String name){
		return employeeService.findEmployeeByName(name);
	}
}
