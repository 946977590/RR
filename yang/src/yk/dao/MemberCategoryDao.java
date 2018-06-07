package yk.dao;

import java.util.List;

import yk.entity.MemberCategory;



public interface MemberCategoryDao {

	List<MemberCategory> findAllMemCategory();

	void addMemCategory(MemberCategory memCategory);

	void deleteMemCategory(MemberCategory memCategory);

	void updateMemCategory(MemberCategory memCategory);
}
