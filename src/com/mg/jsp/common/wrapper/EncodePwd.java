package com.jihunh.jsp.common.wrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePwd {
	
	public String EncodePwd(String key) {
		
		String value = "";
		
		if(key != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(key);
		} else {
			value = key;
		}
		
		return value;
	}
	
}
