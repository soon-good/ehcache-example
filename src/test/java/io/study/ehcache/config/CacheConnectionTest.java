package io.study.ehcache.config;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import io.study.ehcache.employee.Employee;
import io.study.ehcache.employee.EmployeeService;

@SpringBootTest
public class CacheConnectionTest {

	@Autowired
	@Qualifier("employeeCacheManager")
	private CacheManager cacheManager;

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void 캐시동작테스트(){
		Cache<String, Employee> cache = cacheManager.getCache("employeeList", String.class, Employee.class);
		Employee beforeCache = cache.get("손흥민");
		assertThat(beforeCache).isNull();

		List<Employee> employeeList = employeeService.findAllEmployees();
		for(Employee e : employeeList){
			cache.put(e.getName(), e);
		}

		Employee afterCache = cache.get("손흥민");
		assertThat(afterCache).isNotNull();
	}
}
