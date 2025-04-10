package com.Lect.week03;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractCommonService {
	@Autowired
	private Animal cat;
	
	private int defaultValue = 10;

}
