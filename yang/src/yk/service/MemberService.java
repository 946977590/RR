package yk.service;

import java.util.List;

import yk.entity.Member;
import yk.entity.News;
import yk.entity.PageBean;


public interface MemberService {
	
	List<Member> findAll();
	
	void addMember(Member member);

	void updateMember(Member member);
	
	void deleteMember(Member member);
	
	PageBean<Member> findMemberByPage(int currentPage, int pageSize);
}
