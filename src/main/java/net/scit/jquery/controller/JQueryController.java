package net.scit.jquery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.scit.jquery.dto.MemberDTO;

@Controller
@RequestMapping("/jquery")
public class JQueryController {
	@GetMapping("/basic")
	public String basic() {
		return "jquery/basic";
	}
	
	@GetMapping("/css")
	public String css() {
		return "jquery/css";
	}
	
	@GetMapping("/selector")
	public String selector() {
		return "jquery/selector";
	}
	
	@GetMapping("/func")
	public String func() {
		return "jquery/func";
	}	
	
	@GetMapping("/func2")
	public String func2() {
		return "jquery/func2";
	}
	
	@GetMapping("/text")
	public String text() {
		return "jquery/text";
	}
	
	@GetMapping("/val")
	public String val() {
		return "jquery/val";
	}
	
	@PostMapping("/valResult")
	public String valResult(
			@RequestParam(name="username") String username,
			@RequestParam(name="useremail") String useremail
			) {
		
		System.out.println(username + "/" + useremail);
		
		return "redirect:/jquery/val";
	}
	
	// 유효성 검증 페이지 요청
	@GetMapping("/validation")
	public String validation() {
		return "jquery/validation";
	}
	
	@PostMapping("/memberJoin")
	public String memberJoin(@ModelAttribute MemberDTO memberDTO, Model model) {
		System.out.println(memberDTO);
		model.addAttribute("member", memberDTO);
		
		return "jquery/validation";
	}
	
	@GetMapping("/append")
	public String append() {
		
		return "jquery/append";
	}
	
	@GetMapping("/remove")
	public String remove() {
		
		return "jquery/remove";
	}
	
	@GetMapping("/exam01")
	public String exam01() {
		
		return "jquery/exam01";
	}
	
	@GetMapping("/check")
	public String check() {
		
		return "jquery/check";
	}
	
	@GetMapping("/each")
	public String each() {
		
		return "jquery/each";
	}
	@GetMapping("/exam02")
	public String exam02() {
		
		return "jquery/exam02";
	}
	
}







