package com.koreait.sboard.cmt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.sboard.model.BoardCmtEntity;

@Mapper
public interface CmtMapper {
	
	List<BoardCmtEntity> BoardCmtList();
	void insCmt(BoardCmtEntity param);
	void updateCmt(BoardCmtEntity param);
	void delCmt(BoardCmtEntity param);
}
