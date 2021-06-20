package com.bamboo.board.dao;

import java.util.List;
import java.util.Map;

import com.bamboo.board.model.BoardDto;

public interface BoardDao {

	// ---*카운트(Map)
	public int cnt(Map<String, Object> param);

	// ---*리스트
	public List<Map<String, Object>> list(Map<String, Object> param);

	// ---*저장
	public int in(Map<String, Object> param);

	public int postCnt(int idx);

	public int postCurPage(int idx);

	public List<BoardDto> postList(int idx, int start, int end);

	public int postAdd(BoardDto boardDto);

}
