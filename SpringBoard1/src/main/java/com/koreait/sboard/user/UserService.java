package com.koreait.sboard.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.koreait.sboard.common.Const;
import com.koreait.sboard.common.SecurityUtils;
import com.koreait.sboard.common.Utils;
import com.koreait.sboard.model.UserEntity;

@Service
public class UserService {
	@Autowired
	private UserMapper mapper;
	
	
	
	public int login(UserEntity param, HttpSession hs) {
		UserEntity dbData = mapper.selUser(param);
		
		if(dbData == null) {
			return 2;
		}
		String encryptPw = SecurityUtils.hashPassword(param.getUser_pw(), dbData.getSalt());
		if(!dbData.getUser_pw().equals(encryptPw)) {
		
			return 3;
		}
		
		dbData.setSalt(null);
		dbData.setUser_pw(null);
		hs.setAttribute(Const.LOGINUSER, dbData);
		
		
		return 1;
	}
	
	public int insUser(UserEntity param) {
		param.setSalt(SecurityUtils.gensalt());
		param.setUser_pw(SecurityUtils.hashPassword(param.getUser_pw(), SecurityUtils.gensalt()));
		
		return mapper.insUser(param);
		
	
	}

	public UserEntity selUser(UserEntity param) {
		return mapper.selUser(param);
	}
}
