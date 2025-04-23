package com.Lect.week04;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class InitDestroyUnit implements InitializingBean, DisposableBean{
	
	@Bean(initMethod = "init", destroyMethod = "cleanup")
	public InitDestroyUnit myBean() {
		return new InitDestroyUnit();
	}
	public void init() {
		System.out.println("InitDestroyUnit 초기화(init) 메서드 실행");
	}
	public void cleanup() {
		System.out.println("InitDestroyUnit 소멸(cleanup) 메서드 실행");
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("InitDestroyUnit 초기화(@PostConstruct) 메서드 실행");
	}
	@PreDestroy
	public void PreDestroy() {
		System.out.println("InitDestroyUnit 소멸(@PreDestroy) 메서드 실행");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() 메서드 실행");
	}
	 @Override
	 public void afterPropertiesSet() throws Exception{
		 System.out.println("afterPropertiesSet() 메서드 실행");
	 }

}
