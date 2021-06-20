package com.bamboo.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.bamboo.board.model.BoardDto;

public interface BoardService {
	// ---*fo 리스트map
	public boolean list(Map<String, Object> param, ModelMap model) throws Exception;

	// ---*fo 저장
	public boolean in(HttpServletRequest request, Map<String, Object> param, ModelMap model) throws Exception;

	public int postCnt(int idx);

	public int postCurPage(int idx);

	public List<BoardDto> list(int idx, int start, int end);

	public int postAdd(BoardDto boardDto);



}
