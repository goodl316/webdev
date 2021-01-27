package com.koreait.sboard.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.sboard.cmt.CmtMapper;
import com.koreait.sboard.common.SecurityUtils;
import com.koreait.sboard.model.BoardCmtEntity;
import com.koreait.sboard.model.BoardDTO;
import com.koreait.sboard.model.BoardDomain;
import com.koreait.sboard.model.BoardEntity;

import oracle.net.aso.b;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper mapper;
	

	public List<BoardDomain> selBoardList(BoardDTO dto) {
		return mapper.selBoardList(dto);
	}
	
	public BoardDomain selBoard(BoardDTO dto){
		return mapper.selBoard(dto);
	}
	
	public int insBoard(BoardEntity p, HttpServletRequest req) {
		int i_user = SecurityUtils.getLoingUserPk(req);
		p.setI_user(i_user);
		return mapper.insBoard(p);
	}
	
	public void updateBoard(BoardEntity param, HttpServletRequest req) {
		int i_user = SecurityUtils.getLoingUserPk(req);
		param.setI_user(i_user);
		mapper.updateBoard(param);
	}
	
	public void delBoard(BoardEntity param,HttpServletRequest req) {
		int i_user = SecurityUtils.getLoingUserPk(req);
		param.setI_user(i_user);
		mapper.delBoard(param);
	}
	

}
