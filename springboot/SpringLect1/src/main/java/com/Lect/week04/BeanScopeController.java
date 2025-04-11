package com.Lect.week04;

import javax.naming.spi.ObjectFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.Lect.week03.SmsSender;
import com.Lect.week03.WorkUnit;

@Controller
public class BeanScopeController {
	@Autowired
	private WebApplicationContext context;
	
	@GetMapping("/scopeBean")
	public ModelAndView scopeBean (ModelAndView mav) {
		
		SmsSender[][] scopeBeanArray=new SmsSender[4][2];
		for(int i=0;i<4;i++) {
			for(int j=0;j<2;j++) {
				scopeBeanArray[i][j]= (SmsSender)context.getBean("scopeBean"+i);
			}
		}
		mav.addObject("scopeBeanArray", scopeBeanArray);
		mav.setViewName("week04/scopeBeanView");
		return mav;
	}
	
	@GetMapping({"/useDiffentScope"})
	public ModelAndView diffenetScope(ModelAndView mav) {
		WorkUnit[][] scopeBeanArray = new WorkUnit[2][1];
		scopeBeanArray[0] = (WorkUnit[])context.getBean("useDifferentScope");
		scopeBeanArray[1] = (WorkUnit[])context.getBean("useDifferentScope");
		
		mav.addObject("scopeBeanArray", scopeBeanArray);
		mav.setViewName("week04/differentScopeView");
		
		return mav;
	}
	
	@GetMapping("?objectFactoryBeanTest")
	public ModelAndView objectFactoryTest(ModelAndView mav) {
		ObjectFactory<WorkUnit[]> prototypeBeanFactory;
		WorkUnit[][] scopeBeanArray= new WorkUnit[2][1];
		
		prototypeBeanFactory = (ObjectFactory<WorkUnit[]>)context.getBean("objectFactoryBean");
		scopeBeanArray[0] = prototypeBeanFactory.getObject();
		
		prototypeBeanFactory = (ObjectFactory<WorkUnit[]>)context.getBean("objectFactoryBean");
		scopeBeanArray[2] = prototypeBeanFactory.getObject();
		
		mav.addObject("scopeBeanArray", scopeBeanArray);
		mav.setViewName("week04/differentScopeView");
		
		return mav;
		
	}
}
