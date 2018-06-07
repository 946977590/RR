package yk.daoimpl;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import yk.dao.MemberCategoryDao;
import yk.entity.MemberCategory;

@Repository("memberCategoryDao")
public class MemberCategoryDaoImpl implements MemberCategoryDao {

	@Autowired //按类型注入
	private HibernateTemplate hibernateTemplate;
	public List<MemberCategory> findAllMemCategory() {
		// TODO Auto-generated method stub
		return (List<MemberCategory>) hibernateTemplate.find("from MemberCategory");
	}

	@Override
	public void addMemCategory(MemberCategory memCategory) {
		hibernateTemplate.save(memCategory);
	}

	@Override
	public void deleteMemCategory(MemberCategory memCategory) {
		hibernateTemplate.delete(memCategory);
	}

	@Override
	public void updateMemCategory(MemberCategory memCategory) {
		hibernateTemplate.update(memCategory);
	}

}
