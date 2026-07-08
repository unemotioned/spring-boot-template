package kr.or.iei.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.member.model.vo.Member;

// create as interface
@Mapper
public interface MemberDao {
	ArrayList<Member> getList();
}
