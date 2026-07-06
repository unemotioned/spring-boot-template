package kr.or.iei.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.member.model.vo.Member;

// Mapper
@Mapper
public interface MemberDao { // interface 로 생성
	public ArrayList<Member> getList();
}
