package io.study.ehcache.employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> findAllEmployees();
	Employee findEmployeeByName(String name);
}
