package yk.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yk.dao.MemberDao;
import yk.daoimpl.MemberDaoImpl;
import yk.entity.Member;
import yk.entity.News;
import yk.entity.PageBean;
import yk.service.MemberService;
@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired  //注入
	private MemberDao memberDao;
	
	public List<Member> findAll() {
		
		return memberDao.findAll();
		
	}

	public void addMember(Member member) {
		//System.out.println(member.getMemAdress());
		memberDao.addMember(member);
	}

	public void updateMember(Member member) {
		memberDao.updateMember(member);
		
	}

	@Override
	public PageBean<Member> findMemberByPage(int currentPage, int pageSize) {
		int count = memberDao.getMemberCount(); //求当前类别信息数量
		int totalPage = (int) Math.ceil(count*1.0/pageSize);//求总页数
		List<Member> listmember = memberDao.findMemberByPage(currentPage, pageSize); //求当前页的集合数据
		PageBean<Member> pb2 = new PageBean<Member>();
		pb2.setCount(count);
		if(currentPage==0)currentPage=1;
		pb2.setCurrentPage(currentPage);
		pb2.setList(listmember);
		pb2.setPageSize(pageSize);
		pb2.setTotalPage(totalPage);
		return pb2;
	}

	@Override
	public void deleteMember(Member member) {
		memberDao.deleteMember(member);
	}

}
