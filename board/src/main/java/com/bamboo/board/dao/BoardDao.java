package com.bamboo.board.dao;

import java.util.List;
import java.util.Map;

import com.bamboo.board.model.BoardDto;

public interface BoardDao {

	public int postCnt(int idx);

	public int postCurPage(int idx);

	public List<BoardDto> postList(int idx, int start, int end);

	public int postAdd(BoardDto boardDto);

	public BoardDto postSelect(int idx);

	public int postRevise(BoardDto boardDto);

	public int postDelete(BoardDto boardDto);

}
