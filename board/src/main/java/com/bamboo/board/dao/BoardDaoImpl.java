package com.bamboo.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bamboo.board.model.BoardDto;

@Repository("BoardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int postCnt(int idx) {
		System.out.println("다오의 넘버" + idx);

		HashMap<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("idx", idx);

		return sqlSession.selectOne("board.cnt", paramMap);
	}

	@Override
	public int postCurPage(int idx) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("idx", idx);

		return sqlSession.selectOne("board.curPage", paramMap);
	}

	@Override
	public List<BoardDto> postList(int idx, int start, int end) {
		Map<String, Object> map = new HashMap<>();
		map.put("idx", idx);
		map.put("start", start);
		map.put("end", end);
		
		List<BoardDto> postList = sqlSession.selectList("board.list", map);
		System.out.println("postList 보여줘 "+postList);
		return postList;
	}

	@Override
	public int postAdd(BoardDto boardDto) {
		return sqlSession.insert("board.add", boardDto);
	}

	@Override
	public BoardDto postSelect(int idx) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("idx", idx);
		
		BoardDto postSelect = sqlSession.selectOne("board.select", paramMap);
		System.out.println("postSelect는 이렇게 생겼어"+postSelect.toString());
		return postSelect;
	}

	@Override
	public int postRevise(BoardDto boardDto) {
		return sqlSession.update("board.revise", boardDto);
	}

	@Override
	public int postDelete(BoardDto boardDto) {
		return sqlSession.delete("board.delete", boardDto);
	}

}
