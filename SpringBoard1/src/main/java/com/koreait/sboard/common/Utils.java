package com.koreait.sboard.common;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.koreait.sboard.model.UserEntity;
public class Utils {
	
	public static String myViewResolver(String fileNm) {
		
		return "/WEB-INF/views/" + fileNm + ".jsp";
	}
	
	
}
