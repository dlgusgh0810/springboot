package com.Lect.week05;

import org.springframework.stereotype.Service;

@Service
public class ExAOPService {
	
	public void performSensitiveOperation (String msg, int cnt) {
		System.out.println("민감한 작업 실행 중...");
	}
	
	public String placeOrder(double orderID) throws SecurityException{
		double random = Math.random();
		if(random > orderID)
			throw new SecurityException(random + " : " + orderID + "[조건불일치]");
		
		return random+":"+orderID+"[조건일치]";
	}
}
