package com.koreait.sboard.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.sboard.model.UserEntity;


@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	UserService service;
	
	@GetMapping("/login")
	public void login() {
		System.out.println("!!!!!");
	}
	
	@PostMapping("/login")
	public String login(Model model, UserEntity param, HttpSession hs) {
		int result = service.login(param, hs);
		
		if(result==1) {
			return "redirect:/board/home";
		}
		if(result == 2) {
			model.addAttribute("msg","아이디를 확인해 주세요");
			return "redirect:/user/login";
		}
		if(result ==3 ) {
			model.addAttribute("msg","비밀번호를 확인해주세요");
			return "redirect:/user/login";
		}
		
		return null;
		
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession hs) {
		hs.invalidate();
		return "redirect:/user/login";
	}
	@RequestMapping("/join")
	public void join(Model model) {

	}
	
	@PostMapping("/join")
	public String join(UserEntity param) {
		
		service.insUser(param);
		return "redirect:/user/login";
	}
}
