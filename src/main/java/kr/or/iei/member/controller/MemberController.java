package kr.or.iei.member.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

@Controller
public class MemberController {
	private final MemberService service;

	public MemberController(MemberService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/getList")
	public void getList() {
		ArrayList<Member> list = service.getList();

		for (Member member : list) {
			System.out.println("member_id: " + member.getMemberId());
			System.out.println("member_pw: " + member.getMemberPw());
		}
	}
}
