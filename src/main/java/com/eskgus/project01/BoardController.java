package com.eskgus.project01;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eskgus.service.BoardService;
import com.eskgus.domain.BoardVO;

@Controller
@RequestMapping(value = "/")
public class BoardController {
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", service.listAll());
	}
	
	// 글쓰기 페이지 보여주기
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		
	}
	
	// 글쓰기 + db에 저장 + 리스트에 표시
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		service.regist(board);
		
		return "redirect:/listAll";
	}
	
	// 글읽기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno")int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	// 글수정 페이지
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	// 글수정 완료 + 리스트 표시
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		service.modify(board);
		
		return "redirect:/listAll";
	}
	
	// 글 삭제하고 리스트 보여주기
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePost(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		
		return "redirect:/listAll";
	}
}
