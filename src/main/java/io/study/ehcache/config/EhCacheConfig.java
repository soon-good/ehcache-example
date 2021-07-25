package io.study.ehcache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

// @EnableCaching
// @Configuration
public class EhCacheConfig {
	// @Bean
	// public JCacheManagerFactoryBean jCacheManagerFactoryBean(){
	// 	JCacheManagerFactoryBean jCacheManagerFactoryBean = new JCacheManagerFactoryBean();
	// 	jCacheManagerFactoryBean.set
	// 	ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache-2.x.xml"));
	// 	ehCacheManagerFactoryBean.setShared(true);
	// 	return ehCacheManagerFactoryBean;
	// }
	//
	// @Bean
	// public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean ehCacheManagerFactoryBean){
	// 	JCacheCacheManager cacheManager= new JCacheCacheManager();
	// 	cacheManager.setCacheManager(ehCacheManagerFactoryBean.getObject());
	// 	return ehCacheCacheManager;
	// }
}
