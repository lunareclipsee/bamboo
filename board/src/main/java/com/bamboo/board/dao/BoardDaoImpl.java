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

//	// ---*카운트(Map)
//	@Override
//	public int cnt(Map<String, Object> param) {
//		return sqlSession.selectOne("board.cnt", param);
//	}

	// ---*저장
	@Override
	public int in(Map<String, Object> param) {
		System.out.println("DAO IN 했냐??????");
		System.out.println("param에 뭐들어있어??? " + param.toString());
		return sqlSession.insert("board.in", param);
		// --> mapper.xml의 id가 "in"인 tag와 연결됩니다.
	}

	// ---*리스트
	@Override
	public List<Map<String, Object>> list(Map<String, Object> param) {
		return sqlSession.selectList("board.list", param);
	}

	@Override
	public int postCnt(int idx) {
		System.out.println("다오의 넘버" + idx);

		HashMap<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("idx", idx);

		return sqlSession.selectOne("board.cnt", paramMap);
	}

	@Override
	public int cnt(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
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
		
		List<BoardDto> postList = 
				sqlSession.selectList("board.list", map);
		return postList;
	}

	@Override
	public int postAdd(BoardDto boardDto) {
		return sqlSession.insert("board.add", boardDto);
	}

}
