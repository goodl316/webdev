package com.koreait.sboard.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.sboard.common.SecurityUtils;
import com.koreait.sboard.model.BoardDTO;
import com.koreait.sboard.model.BoardDomain;
import com.koreait.sboard.model.BoardEntity;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/home")
	public void home() {
		
	}
	
	@RequestMapping("/list")
	public void list(Model model, BoardDTO dto) {
		model.addAttribute("jsList",  new String[]{"board"});
		model.addAttribute("list",service.selBoardList(dto));
	}
	
	@RequestMapping("/detail")
	public void detail(BoardDTO dto, Model model) {
		model.addAttribute("data",service.selBoard(dto));
		model.addAttribute("jsList",  new String[]{"board","axios.min"});
		
	}
	
	@RequestMapping("/reg")
	public String reg() {
		return "board/regmod";
	}
	@PostMapping("/reg")
	public String reg(BoardEntity p, HttpServletRequest req,Model model) {
		
		model.addAttribute("data",service.insBoard(p, req));
		return "redirect:/board/detail?i_board="+p.getI_board();
	}
	@RequestMapping("/mod")
	public String mod(BoardDTO dto, Model model) {
		model.addAttribute("data",service.selBoard(dto));
		return "board/regmod";
	}
	
	@PostMapping("/mod")
	public String mod(HttpServletRequest req, BoardDTO dto) {
		service.updateBoard(dto, req);
		return "redirect:/board/detail?i_board="+dto.getI_board();
	}
	
	@GetMapping("/del")
	public String del(BoardDTO dto,HttpServletRequest req) {
		service.delBoard(dto,req);
		return "redirect:/board/list?typ="+dto.getTyp();
	}
	
	
}
