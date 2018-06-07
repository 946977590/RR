package yk.daoimpl;   
       
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yk.dao.MemberDao;
import yk.entity.Member;
import yk.entity.News;
@Repository("memberDao")

public class MemberDaoImpl implements MemberDao {

	@Autowired //按类型注入
	private HibernateTemplate hibernateTemplate;
	//private Member member=new Member();
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		//System.out.println(member);
		return (List<Member>) hibernateTemplate.find("from Member");
		
	}

	public void addMember(Member member) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(member);
	}

	public void updateMember(Member member) {
		hibernateTemplate.update(member);		
	}

	@Override
	public int getMemberCount() {
		String sql = "select count(*) from Member where 1=1";
		List list1 = new ArrayList<>();	
		List<Long> list = (List<Long>) hibernateTemplate.find(sql, list1.toArray());		
		return list.get(0).intValue();	//强转long型为int型
	}

	@Override
	public List<Member> findMemberByPage(int currentPage, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Member.class);
		//criteria.addOrder(Order.asc("publishTime"));	//按照发布时间排序
		return (List<Member>) hibernateTemplate.findByCriteria(criteria , (currentPage-1)*pageSize, pageSize);
	}

	@Override
	public void deleteMember(Member member) {
		hibernateTemplate.delete(member);
		
	}
	
	
}
