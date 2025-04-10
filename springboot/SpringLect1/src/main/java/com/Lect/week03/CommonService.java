package com.Lect.week03;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CommonService extends AbstractCommonService {
	private int periodTime;

}
