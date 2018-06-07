package yk.dao;

import java.util.List;

import yk.entity.Member;
import yk.entity.News;

public interface MemberDao {

	List<Member> findAll();
	void addMember(Member member);
	void updateMember(Member member);
	void deleteMember(Member member);
	int getMemberCount();

	List<Member> findMemberByPage(int currentPage, int pageSize);
}
