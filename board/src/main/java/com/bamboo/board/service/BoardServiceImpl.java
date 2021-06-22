package com.bamboo.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.bamboo.board.dao.BoardDao;
import com.bamboo.board.model.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	BoardDao BoardDao; // --- Dao 빈 주입

	@Override
	public int postCnt(int idx) {
		log.info("Welcome studentQuestionCount! {}", idx);
		System.out.println("dddddddddddddddddddddddddddddddddddd");
		return BoardDao.postCnt(idx);
	}

	@Override
	public int postCurPage(int idx) {
		// TODO Auto-generated method stub
		return BoardDao.postCurPage(idx);
	}

	@Override
	public List<BoardDto> list(int idx, int start, int end) {

		List<BoardDto> postList = 
				BoardDao.postList(idx, start, end);
		
		return postList;
		
	}

	@Override
	public int postAdd(BoardDto boardDto) {
		int resultNum = 0;
		resultNum= BoardDao.postAdd(boardDto);
		return resultNum;
	}

	@Override
	public Map<String, Object> postSelect(int idx) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		BoardDto boardDto = BoardDao.postSelect(idx);
		resultMap.put("BoardDto", boardDto);
		System.out.println("resultMap"+resultMap.toString());
		return resultMap;
	}

	@Override
	public int postRevise(BoardDto boardDto) {
		int resultNum = 0;
		resultNum= BoardDao.postRevise(boardDto);
		System.out.println("데이터베이스 빠져나옴"+resultNum);
		return resultNum;
	}

	@Override
	public int postDelete(BoardDto boardDto) {
		int resultNum = 0;
		resultNum= BoardDao.postDelete(boardDto);
		System.out.println("데이터베이스 빠져나옴"+resultNum);
		return resultNum;
	}


}
