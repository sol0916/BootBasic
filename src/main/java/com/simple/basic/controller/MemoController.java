package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.service.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	@Qualifier("memoService")
	private MemoService memoService;
	
	
	//글쓰기화면
	@GetMapping("/memoWrite")
	public String memoWrite() {
		return "memo/memoWrite";
	}
	
	//등록요청
	@PostMapping("/memoForm")
	public String memoForm(@Valid @ModelAttribute("vo") MemoVO vo, Errors errors, Model model ) {
		
		if(errors.hasErrors()) {
			
			List<FieldError> list = errors.getFieldErrors();
			
			for(FieldError err : list) {
				model.addAttribute("valid_"+err.getField(), err.getDefaultMessage());
			}
			
			return "memo/memoWrite";
		} //err end
		
		
		memoService.memoRegist(vo);
		
		return "redirect:/memo/memoList";
	}
	
	
	//목록화면
	@GetMapping("/memoList")
	public String memoList(Model model) {
		
		ArrayList<MemoVO> list = memoService.getMemo();
		model.addAttribute("list", list);
		
		return "memo/memoList";
	}
	
	//삭제
	@GetMapping("/memoDelete")
	public String memoDelete(@RequestParam("mno") int mno) {
		
		memoService.memoDelete(mno);
		
		return "redirect:/memo/memoList";
	}

}
