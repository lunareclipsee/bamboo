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
	public boolean in(HttpServletRequest request, Map<String, Object> param, ModelMap model) throws Exception {

		Map<String, Object> svcMap = new HashMap<>();
		System.out.println("제목넘어오냐? " + param.get("title") + "\t 내용넘어오냐? " + param.get("content"));
		System.out.println("모델넘어오냐? " + model.toString());
		// ---* 게시글 저장
		svcMap.put("title", param.get("title"));
		svcMap.put("content", param.get("content"));
//		svcMap.put("password", param.get("password"));
		svcMap.put("readcnt", 0);
		svcMap.put("commentcnt", 0);
		svcMap.put("recommendcnt", 0);
		svcMap.put("groupnum", 0);
		svcMap.put("levelnum", 0);
		svcMap.put("stepnum", 0);
		svcMap.put("inip", request.getRemoteAddr());

		BoardDao.in(svcMap);

		// --- 게시글 저장 끝
		System.out.println("이건뭐야??????   " + BoardDao.in(svcMap));
		// ---* 그룹번호 업데이트
		int seq = Integer.parseInt(svcMap.get("seq").toString());
		svcMap.put("seq", seq);
		svcMap.put("groupnum", seq);

//		BoardDao.up(svcMap); // ---up method 실행
//		// ---* 그룹번호 업데이트 끝

		return true;
	}

	@Override
	public boolean list(Map<String, Object> param, ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> svcMap = new HashMap<>();

		List<Map<String, Object>> postList = BoardDao.list(svcMap); // --- Dao의 list method를 호출해서 게시글 목록
		System.out.println("서비스 어떤값받아오냐 " + postList.toString()); // 가져오기

		int count = BoardDao.cnt(svcMap); // --- 페이징 처리를 위해 게시글 전체 count를 가져오기.

		model.put("postList", postList); // --- 목록 model에 담기. view로 가져가기 위해서
		model.put("count", count);
		System.out.println("모델 어떻게 생김? " + model.toString()); // 가져오기

		return true;
	}

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

}
