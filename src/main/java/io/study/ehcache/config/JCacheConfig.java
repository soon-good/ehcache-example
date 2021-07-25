package io.study.ehcache.config;

import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.study.ehcache.employee.Employee;

@EnableCaching
@Configuration
public class JCacheConfig {

	@Bean(name = "employeeCacheManager")
	public CacheManager cacheManager(){
		final CacheConfiguration<String, Employee> cacheConfigBuilder = CacheConfigurationBuilder
			.newCacheConfigurationBuilder(
				String.class, Employee.class,
				ResourcePoolsBuilder.newResourcePoolsBuilder()
					// .heap(10) // 정말 간단하게 하려면 아래 세줄 대신 이 한줄로 하면 된다. (대신 디스크 설정 및 여러가지 사항들은 세부적으로 설정 불가)
					.heap(10, EntryUnit.ENTRIES)
					.offheap(1, MemoryUnit.MB)
					.disk(20, MemoryUnit.MB, true)
			)
			.withExpiry(ExpiryPolicyBuilder.noExpiration())
			.build();

		final CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
			.with(CacheManagerBuilder.persistence("sgjung.io.tmpdir"))
			.withCache("employeeList", cacheConfigBuilder)
			.build();

		cacheManager.init();

		return cacheManager;
	}
}
