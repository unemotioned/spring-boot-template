package kr.or.iei.member.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

@Service
public class MemberService {

	private final MemberDao dao;

	public MemberService(MemberDao dao) {
		this.dao = dao;
	}

	public ArrayList<Member> getList() {
		return dao.getList();
	}
}
