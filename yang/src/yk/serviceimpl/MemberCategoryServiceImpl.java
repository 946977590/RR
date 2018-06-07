package yk.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yk.dao.MemberCategoryDao;
import yk.entity.MemberCategory;
import yk.service.MemberCategoryService;

@Service("memberCategoryService")
@Transactional
public class MemberCategoryServiceImpl implements MemberCategoryService{

	@Autowired  //注入
	private MemberCategoryDao memberCategoryDao;
	public List<MemberCategory> findAllMemCategory() {
		// TODO Auto-generated method stub
		return memberCategoryDao.findAllMemCategory();
	}

	@Override
	public void addMemCategory(MemberCategory memCategory) {
		memberCategoryDao.addMemCategory(memCategory);
		
	}

	@Override
	public void deleteMemCategory(MemberCategory memCategory) {
		memberCategoryDao.deleteMemCategory(memCategory);		
	}

	@Override
	public void updateMemCategory(MemberCategory memCategory) {
		memberCategoryDao.updateMemCategory(memCategory);		
	}

}
