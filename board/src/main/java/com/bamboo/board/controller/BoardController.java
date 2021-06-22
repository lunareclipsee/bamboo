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

	// 게시글 리스트
	@RequestMapping(value = "postList.do", method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "0") int idx,
			Model model) {
		log.info("Welcome postList.do\"! {}");
		System.out.println("들어온 idx의 값" + idx);

		int totalCount = 0;

		totalCount = BoardService.postCnt(idx);
		System.out.println("카운트몇? " + totalCount);
		System.out.println("curPage 몇? " + curPage);

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
		
		System.out.println("pagingMap 뭐들었어?" + pagingMap);
		model.addAttribute("postList", postList);
		model.addAttribute("pagingMap", pagingMap);

		return "bambooforest/postList";
	}

	// 게시글 작성
	@RequestMapping(value = "postAdd.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(Model model) {
		log.info("Welcome postAdd.do! ");

		return "bambooforest/postAdd";
	}

	// 게시글 저장
	@RequestMapping(value = "postAddCtr.do", method = RequestMethod.POST)
	public String add(BoardDto boardDto, HttpServletRequest request, Model model) {
		log.info("Welcome postAddCtr.do! ");
		int resultNum = 0;
		boardDto.setInip(request.getLocalAddr());
		resultNum = BoardService.postAdd(boardDto);
		System.out.println("결과값" + resultNum);

		return "redirect:/bambooforest/postList.do";
//		request받는건 ip받기위해서
	}

	// 게시글 조회
	@RequestMapping(value = "postSelect.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String select(int idx, Model model) {
		log.info("Welcome postSelect.do! {} " + idx);

		Map<String, Object> map = BoardService.postSelect(idx);

		BoardDto boardDto = (BoardDto) map.get("BoardDto");

		System.out.println("컨트롤러에 있는 boardDto는 이렇게 생김 " + boardDto);
		model.addAttribute("boardDto", boardDto);

		return "bambooforest/postRead";
	}

	// 게시글 수정
	@RequestMapping(value = "postRevise.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String revise(int idx, Model model) {
		log.info("Welcome postRevise.do! ");

		Map<String, Object> map = BoardService.postSelect(idx);

		BoardDto boardDto = (BoardDto) map.get("BoardDto");
		model.addAttribute("boardDto", boardDto);

		return "bambooforest/postRevise";
	}

	// 게시글 수정최종
	@RequestMapping(value = "postReviseCtr.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviseCtr(BoardDto boardDto, Model model) {
		log.info("Welcome postReviseCtr.do! ");
		int resultNum = 0;
		resultNum = BoardService.postRevise(boardDto);
		// 성공 1 실패 0
		int idx = boardDto.getIdx();

		return "redirect:/bambooforest/postSelect.do?idx=" + idx;
	}

	// 게시글 삭제
	@RequestMapping(value = "postDeleteCtr.do", method = RequestMethod.POST)
	public String deleteCtr(BoardDto boardDto, Model model) {
		log.info("call postDeleteCtr! ");
		int resultNum = 0;
		resultNum = BoardService.postDelete(boardDto);
		// 성공 1 실패 0
		System.out.println("삭제 서비스 완료");

		return "redirect:/bambooforest/postList.do";
	}

}
