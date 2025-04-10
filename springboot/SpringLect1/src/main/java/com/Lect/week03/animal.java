package com.Lect.week03;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public interface animal{
	String sound();
}

@Component
class Dog implements animal{
	@Override
	public String sound() {
		return "Woof";
	}
}

@Component
@Primary
class Cat implements animal{
	@Override
	public String sound() {
		return "Meow";
	}
}