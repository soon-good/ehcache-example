package io.study.ehcache.employee;

import java.util.Arrays;
import java.util.List;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final CacheManager cacheManager;

	public EmployeeServiceImpl(@Qualifier("employeeCacheManager") CacheManager cacheManager){
		this.cacheManager = cacheManager;
	}

	@Override
	public List<Employee> findAllEmployees() {
		Employee e1 = Employee.builder().name("지드래곤").salary(99999D).build();
		Employee e2 = Employee.builder().name("손흥민").salary(99999D).build();
		Employee e3 = Employee.builder().name("황의조").salary(99997D).build();

		return Arrays.asList(e1, e2, e3);
	}

	@Cacheable(
		key = "#name",
		value = "employeeList"
	)
	@Override
	public Employee findEmployeeByName(String name) {
		Cache<String, Employee> cache = cacheManager.getCache("employeeList", String.class, Employee.class);

		Employee cacheResult = findCacheByName(name);
		if(cacheResult != null){
			System.out.println("[캐시 적중]");
			return cacheResult;
		}
		else{
			System.out.println("[캐시 누락]");
			List<Employee> list = findAllEmployees();
			Employee result = null;
			for(Employee e : list){
				if(e.getName().equals(name)){
					cache.put(name, e);
					result = e;
					break;
				}
			}
			return result;
		}
	}

	public Employee findCacheByName(String name){
		Cache<String, Employee> cache = cacheManager.getCache("employeeList", String.class, Employee.class);
		return (Employee)cache.get(name);
	}

}
