package io.study.ehcache.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class SampleDataRunner implements CommandLineRunner {

	// private final CacheManager cacheManager;
	//
	// public SampleDataRunner(CacheManager cacheManager){
	// 	this.cacheManager = cacheManager;
	// }

	@Override
	public void run(String... args) throws Exception {
		// System.out.println(this.cacheManager.getClass().getName());
	}
}
