package com.koreait.sboard.cmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.sboard.model.BoardCmtEntity;


@Service
public class BoardCmtService {
	
	@Autowired
	CmtMapper mapper;

	
	public List<BoardCmtEntity> selCmtList(){
		return mapper.BoardCmtList();
	}
	
	public void reg(BoardCmtEntity param) {
		mapper.insCmt(param);
	}
	
	public void mod(BoardCmtEntity param) {
		mapper.updateCmt(param);
	}
	
	public void del(BoardCmtEntity param) {
		mapper.delCmt(param);
	}

}

