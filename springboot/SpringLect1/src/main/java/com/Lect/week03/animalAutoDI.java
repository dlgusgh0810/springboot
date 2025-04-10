package com.Lect.week03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class animalAutoDI {
	
	@Autowired
	private animal cat;
	
	private SmsSender sms;
	public animalAutoDI(@Qualifier("xmlSms")SmsSender sms) {
		this.sms = sms;
	}
	
	public animal dog;
	@Autowired
	public void setDog(@Qualifier("dog")animal dog) {
		this.dog=dog;
	}

}
