package com.Lect.week03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AnimalAutoDI {
	
	@Autowired
	private Animal cat;
	
	private SmsSender sms;
	public AnimalAutoDI(@Qualifier("xmlSms")SmsSender sms) {
		this.sms = sms;
	}
	
	public Animal dog;
	@Autowired
	public void setDog(@Qualifier("dog")Animal dog) {
		this.dog=dog;
	}

}
