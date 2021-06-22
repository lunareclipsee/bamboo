package com.bamboo.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.bamboo.board.model.BoardDto;

public interface BoardService {

	public int postCnt(int idx);

	public int postCurPage(int idx);

	public List<BoardDto> list(int idx, int start, int end);

	public int postAdd(BoardDto boardDto);

	public Map<String, Object> postSelect(int idx);

	public int postRevise(BoardDto boardDto);

	public int postDelete(BoardDto boardDto);



}
