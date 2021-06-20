package com.bamboo.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bamboo.board.model.BoardDto;
import com.bamboo.board.service.BoardService;
import com.bamboo.util.Paging;

@Controller
@RequestMapping("/bambooforest/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService BoardService;

	@RequestMapping("/index")
	private String indexMain() {

		return "index";
	}

	// ---* 리스트
	@RequestMapping(value = "postList.do", method = RequestMethod.GET)
	public String list(@RequestParam Map<String, Object> param, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "0") int idx, Model model) {
		log.info("Welcome postList.do\"! {}");
		System.out.println("들어온 idx의 값" + idx);

		int totalCount = 0;

		totalCount = BoardService.postCnt(idx);
		System.out.println("카운트몇? " + totalCount);

		if (idx != 0) {
			curPage = BoardService.postCurPage(idx);
			System.out.println("curPage 이제 나오냐? " + curPage);
			// 이건 글읽고 나올때 씀
		}

		Paging postPaging = new Paging(totalCount, curPage);
		int start = postPaging.getPageBegin();
		int end = postPaging.getPageEnd();

		List<BoardDto> postList = BoardService.list(idx, start, end);

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("postPaging", postPaging);
		model.addAttribute("postList", postList);
		model.addAttribute("pagingMap", pagingMap);

//		try {
//			BoardService.list(param, model);
//			System.out.println("dddddddd" + BoardService.list(param, model));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return "bambooforest/postList";
	}

	// ---* 게시글 작성하기
	@RequestMapping(value = "postAdd.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(Model model) {
		log.info("Welcome postAdd.do! ");

		return "bambooforest/postAdd";
	}

	// ---* 저장
	@RequestMapping(value = "postAddCtr.do", method = RequestMethod.POST)
	public String in(BoardDto boardDto, HttpServletRequest request, Model model) {
		log.info("Welcome postAddCtr.do! ");
		System.out.println("request이거 뭐나오냐? "+request.getLocalAddr());
		System.out.println("boardDto 이거뭔데? " + boardDto);
		int resultNum = 0;
		boardDto.setInip(request.getLocalAddr());
		resultNum = BoardService.postAdd(boardDto);
		System.out.println("결과값" + resultNum);

		return "redirect:/bambooforest/postList.do";
//		request받는건 ip받기위해서
//		새로고침으로 중복등록 방지
	}

}
