package com.Lect.week04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.Lect.week03.SmsSender;

@Configuration
public class BeanScopeConfig {
	@Bean(name = "scopeBean0")
	public SmsSender singletonBean() {
		return new SmsSender();
	}
	@Bean(name ="scopeBean1")
	@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SmsSender prototypeBean() {
		return new SmsSender();
	}
	@Bean(name ="scopeBean2")
	@RequestScope
	public SmsSender requestBean() {
		return new SmsSender();
	}
	@Bean(name ="scopeBean3")
	@SessionScope
	public SmsSender sessioneBean() {
		return new SmsSender();
	}
	
	
}
