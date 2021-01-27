package com.koreait.sboard.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.sboard.model.BoardDTO;
import com.koreait.sboard.model.BoardDomain;
import com.koreait.sboard.model.BoardEntity;

@Mapper
public interface BoardMapper {
	List<BoardDomain> selBoardList(BoardDTO dto);
	BoardDomain selBoard(BoardDTO dto);
	void favorite(BoardEntity param);
	int insBoard(BoardEntity param);
	int updateBoard(BoardEntity param);
	int delBoard(BoardEntity param);
	
}
